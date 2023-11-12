package com.example.marketplace.service.Impl;

import com.example.marketplace.Enum.EAdvertisementSoldStats;
import com.example.marketplace.Enum.EAdvertisementStats;
import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementNewDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementUpdateDtos;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Advertisement;
import com.example.marketplace.entity.Product;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.repository.IAdvertisementRepository;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IProductRepository;
import com.example.marketplace.service.IAdvertisementService;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Transactional
@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements IAdvertisementService {

    private final IAdvertisementRepository advertisementRepository;
    private final IAccountRepository accountRepository;

    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public SuccessDto postAdvertisement(AdvertisementNewDto advertisementNewDto) {
        Optional<Account> account = accountRepository.findById(advertisementNewDto.getAccountId());
        Optional<Product> product = productRepository.findById(advertisementNewDto.getProductId());
        Advertisement advertisement = Advertisement.builder()
                .account(account.orElseThrow(() -> new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND)))
                .product(product.orElseThrow(() -> new EntityNotFoundException("Product not found", ErrorCodes.PRODUCT_NOT_FOUND)))
                .title(advertisementNewDto.getTitle())
                .description(advertisementNewDto.getDescription())
                .advertisementStats(EAdvertisementStats.UNDER_REVIEW)
                .advertisementSoldStats(EAdvertisementSoldStats.AVAILABLE)
                .oldPrice(advertisementNewDto.getPrice())
                .price(advertisementNewDto.getPrice())
                .build();

        advertisementRepository.save(advertisement);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateAdvertisement(AdvertisementUpdateDtos advertisementUpdateDto, Integer advertisementId) {
        Optional<Advertisement> existingAdvertisement = advertisementRepository.findById(advertisementId);
        if (existingAdvertisement.isEmpty()) {
            throw new EntityNotFoundException("Advertisement not found", ErrorCodes.ADVERTISEMENT_NOT_FOUND);
        }

        Advertisement updatedAdvertisement = modelMapper.map(advertisementUpdateDto, Advertisement.class);
        updatedAdvertisement.setId(advertisementId);

        advertisementRepository.save(updatedAdvertisement);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }


    @Override
    public AdvertisementDto getAdvertisementById(Integer advertisementId) {
        Optional<Advertisement> advertisement = advertisementRepository.findById(advertisementId);
        if (advertisement.isEmpty()) {
            throw new EntityNotFoundException("Advertisement not found", ErrorCodes.ADVERTISEMENT_NOT_FOUND);
        }

        return modelMapper.map(advertisement.get(), AdvertisementDto.class);
    }

    @Override
    public List<AdvertisementDto> getAllAdvertisement() {
        return advertisementRepository.findAll()
                .stream()
                .map(AdvertisementDto::customMapping)
                .collect(Collectors.toList());
    }



    @Override
    public List<AdvertisementDto> getAdvertisementByAccount(Integer accountId) {
        Optional<Account> account = accountRepository.findById(accountId);

        if (account.isEmpty()) {
            throw new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND);
        }

        List<Advertisement> advertisements = advertisementRepository.findAdvertisementByAccount_AccountId(accountId);

        return advertisements.stream()
                .map(AdvertisementDto::customMapping)
                .collect(Collectors.toList());
    }


    @Override
    public SuccessDto deleteAdvertisement(Integer advertisementId) {
        Optional<Advertisement> advertisement = advertisementRepository.findById(advertisementId);
        if (advertisement.isEmpty()) {
            throw new EntityNotFoundException("Advertisement not found", ErrorCodes.ADVERTISEMENT_NOT_FOUND);
        }

        advertisementRepository.delete(advertisement.get());

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_REMOVED)
                .build();
    }



    @Override
    public List<AdvertisementDto> getMyFeedList(AccountDto accountDto) {
        return null;
    }
}
