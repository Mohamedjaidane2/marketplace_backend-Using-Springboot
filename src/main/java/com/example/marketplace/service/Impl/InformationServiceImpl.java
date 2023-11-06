package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.InformationDtos.InformationNewDto;
import com.example.marketplace.dto.InformationDtos.InformationUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Address;
import com.example.marketplace.entity.Information;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IInformationRepository;
import com.example.marketplace.service.IAccountService;
import com.example.marketplace.service.IInformationServices;
import com.example.marketplace.utils.SuccessMessage;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements IInformationServices {

    private final IInformationRepository iInformationRepository;
    private final IAccountRepository iAccountRepository;
    private final ModelMapper modelMapper;
    @Override
    public SuccessDto addInformation(InformationNewDto informationNewDto) {

        Optional<Account> account = iAccountRepository.findById(informationNewDto.getAccount());
        Information information= Information.builder()
                .bio(informationNewDto.getBio())
                .firstName(informationNewDto.getFirstName())
                .lastName(informationNewDto.getLastName())
                .comnsumerType(informationNewDto.getConsumerType())
                .phoneNumber(informationNewDto.getPhoneNumber())
                .profilePicture(informationNewDto.getProfilePicture())
                .account(account.get())
                .build();
        iInformationRepository.save(information);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateInformation(InformationUpdateDto informationUpdateDto, Integer infoId) {
        Information information = iInformationRepository.findById(infoId)
                .orElseThrow(() -> new EntityNotFoundException("Information not found", ErrorCodes.INFORMATION_NOT_FOUND));

        modelMapper.map(informationUpdateDto, information);
        iInformationRepository.save(information);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public InformationDto getInformationById(Integer informationId) {
        Optional<Information> information = iInformationRepository.findInformationWithAddressesById(informationId);
        if (information.isEmpty()) {
            throw new EntityNotFoundException("Information not found", ErrorCodes.INFORMATION_NOT_FOUND);
        }
        return InformationDto.customMapping(information.get());
    }


    @Override
    public List<InformationDto> getAllInformation() {
        return iInformationRepository.findAll()
                .stream()
                .map(InformationDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteInformationById(Integer informationId) {
        Optional<Information> information = iInformationRepository.findById(informationId);
        if(information.isEmpty())
            throw new EntityNotFoundException("Information not found!",ErrorCodes.INFORMATION_NOT_FOUND);
        iInformationRepository.delete(information.get());
        return SuccessDto
                .builder()
                .message(SuccessMessage.SUCCESSFULLY_DELETED)
                .build();
    }
    }

