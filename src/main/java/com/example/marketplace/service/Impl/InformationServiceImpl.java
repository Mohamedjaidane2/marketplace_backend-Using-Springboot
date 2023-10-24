package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.InformationDtos.InformationNewDto;
import com.example.marketplace.dto.InformationDtos.InformationUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Address;
import com.example.marketplace.entity.Information;
import com.example.marketplace.repository.IInformationRepository;
import com.example.marketplace.service.IInformationServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements IInformationServices {

    private final IInformationRepository iInformationRepository;
    @Override
    public SuccessDto addInformation(InformationNewDto informationNewDto) {

        Information information= Information.builder()
                .bio(informationNewDto.getBio())
                .firstName(informationNewDto.getFirstName())
                .lastName(informationNewDto.getLastName())
                .comnsumerType(informationNewDto.getConsumerType())
                .phoneNumber(informationNewDto.getPhoneNumber())
                .profilePicture(informationNewDto.getProfilePicture())
                .build();
        iInformationRepository.save(information);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateInformation(InformationUpdateDto informationUpdateDto) {
        return null;
    }

    @Override
    public InformationDto getInformationById(String informationId) {
        return null;
    }

    @Override
    public InformationDto getInformationByAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public List<InformationDto> getAllInformation() {
        return null;
    }

    @Override
    public SuccessDto deleteInformationById(String informationId) {
        return null;
    }
}
