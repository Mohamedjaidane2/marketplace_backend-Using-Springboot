package com.example.marketplace.service.Impl;

import com.example.marketplace.Enum.EDiscountRequestStats;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestNewDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateCounterDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.*;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IAdvertisementRepository;
import com.example.marketplace.repository.IDiscountRequestRepository;
import com.example.marketplace.service.IDiscountRequestServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DiscountRequestServiceImpl implements IDiscountRequestServices {
    private final IAccountRepository accountRepository;
    private final IAdvertisementRepository advertisementRepository;
    private final IDiscountRequestRepository discountRequestRepository;

    private final OrderServiceImpl orderService;

    private final ModelMapper modelMapper;

    @Override
    public SuccessDto sendDiscount(Integer accountId, Integer advertisementId, DiscountRequestNewDto discountRequestNewDto) {
        // Retrieve the account and advertisement
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND));

        Advertisement advertisement = advertisementRepository.findById(advertisementId)
                .orElseThrow(() -> new EntityNotFoundException("Advertisement not found", ErrorCodes.ADVERTISEMENT_NOT_FOUND));

        // Check if the account is the owner of the advertisement
        if (advertisement.getAccount().getAccountId().equals(accountId)) {
            throw new InvalidOperationException("You can't send a discount request to your own advertisement", ErrorCodes.CANNOT_SEND_DISCOUNT_TO_OWN_ADVERTISEMENT);
        }

        // Check if the account has already sent a discount request for the specified advertisement
        boolean hasSentDiscountRequest = discountRequestRepository.existsByAccountAndAdvertisement(account, advertisement);

        if (hasSentDiscountRequest) {
            throw new InvalidOperationException("You've already sent a discount request on this advertisement", ErrorCodes.REQUESTED_DISCOUNT_ALREADY_IN_USE);
        }

        // Create a new DiscountRequest using the builder pattern
        DiscountRequest discountRequest = DiscountRequest.builder()
                .account(account)
                .advertisement(advertisement)
                .requestedAmount(discountRequestNewDto.getRequestedAmount())
                .eDiscountRequestStats(EDiscountRequestStats.WAITING)
                .build();

        // Save the created DiscountRequest
        discountRequestRepository.save(discountRequest);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }


    @Override
    public SuccessDto counterDiscount(Integer discountRequestId, DiscountRequestUpdateCounterDto discountRequestUpdateCounterDto) {
        // Retrieve the discount request to be countered
        DiscountRequest discountRequest = discountRequestRepository.findById(discountRequestId)
                .orElseThrow(() -> new EntityNotFoundException("Discount Request not found", ErrorCodes.REQUESTED_DISCOUNT_NOT_FOUND));

        // Counter the discount by updating the counterDiscountAmount
        modelMapper.map(discountRequestUpdateCounterDto, discountRequest);
        discountRequest.setEDiscountRequestStats(EDiscountRequestStats.COUNTERED);
        discountRequestRepository.save(discountRequest);

        return SuccessDto.builder()
                .message("Discount request countered successfully")
                .build();
    }



    @Override
    public SuccessDto updateDiscount(Integer discountRequestId, DiscountRequestUpdateDto discountRequestUpdateDto) {
        // Check if the discount request exists
        DiscountRequest discountRequest = discountRequestRepository.findById(discountRequestId)
                .orElseThrow(() -> new EntityNotFoundException("Discount Request not found", ErrorCodes.REQUESTED_DISCOUNT_NOT_FOUND));

        // Update the discount amount using modelMapper
        modelMapper.map(discountRequestUpdateDto, discountRequest);

        // Save the updated DiscountRequest
        discountRequestRepository.save(discountRequest);

        return SuccessDto.builder()
                .message("Discount Amount updated successfully")
                .build();
    }


    @Override
    public DiscountRequestDto getDiscountById(Integer discountId) {

        Optional<DiscountRequest> discountRequest = discountRequestRepository.findById(discountId);
        if (discountRequest.isEmpty()) {
            throw new EntityNotFoundException("Discount not found", ErrorCodes.REQUESTED_DISCOUNT_NOT_FOUND);
        }
        return DiscountRequestDto.customMapping(discountRequest.get());
    }

    @Override
    public List<DiscountRequestDto> getAllDiscount() {
        return discountRequestRepository.findAll()
                .stream()
                .map(DiscountRequestDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteDiscountRequestById(Integer discountId) {
        Optional<DiscountRequest> discountRequest = discountRequestRepository.findById(discountId);
        if (discountRequest.isEmpty()) {
            throw new EntityNotFoundException("Discount not found", ErrorCodes.REQUESTED_DISCOUNT_NOT_FOUND);
        }
        discountRequestRepository.delete(discountRequest.get());

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_REMOVED)
                .build();
    }
    @Override
    public List<DiscountRequestDto> getDiscountByAccountId(Integer accountId) {
        List<DiscountRequest> discountRequests = discountRequestRepository.findByAccountAccountId(accountId);
        return discountRequests.stream()
                .map(DiscountRequestDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscountRequestDto> getDiscountByAdvertisementOwnerId(Integer advertisementOwnerId) {
        List<DiscountRequest> discountRequests = discountRequestRepository.findByAdvertisementAccountAccountId(advertisementOwnerId);
        return discountRequests.stream()
                .map(DiscountRequestDto::customMapping)
                .collect(Collectors.toList());
    }
    @Override
    public SuccessDto acceptDiscount(Integer discountId) {
        // Retrieve the discount request
        DiscountRequest discountRequest = discountRequestRepository.findById(discountId)
                .orElseThrow(() -> new EntityNotFoundException("Discount Request not found", ErrorCodes.REQUESTED_DISCOUNT_NOT_FOUND));

        // Retrieve the related advertisement
        Advertisement advertisement = discountRequest.getAdvertisement();

        Account account = discountRequest.getAccount();

        // Set the price of the advertisement to the requested amount in the discount request
        advertisement.setPrice(discountRequest.getRequestedAmount());

        // Save the updated advertisement
        advertisementRepository.save(advertisement);

        // Use the toOrder method to place an order for the advertisement
        orderService.toOrder(account.getAccountId(),advertisement.getId());

        // Delete all discount requests related to the advertisement
        List<DiscountRequest> discountRequests = discountRequestRepository.findByAdvertisementId(advertisement.getId());

        discountRequest.setEDiscountRequestStats(EDiscountRequestStats.ACCEPTED);
        discountRequestRepository.deleteAll(discountRequests);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_ACCEPTED)
                .build();
    }

    @Override
    public SuccessDto declineDiscount(Integer discountId) {
        // Retrieve the discount request
        DiscountRequest discountRequest = discountRequestRepository.findById(discountId)
                .orElseThrow(() -> new EntityNotFoundException("Discount Request not found", ErrorCodes.REQUESTED_DISCOUNT_NOT_FOUND));

        // Update the eDiscountRequestStats to DECLINED
        discountRequest.setEDiscountRequestStats(EDiscountRequestStats.DECLINED);
        discountRequestRepository.save(discountRequest);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_DECLINED)
                .build();
    }



}
