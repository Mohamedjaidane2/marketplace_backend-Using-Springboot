package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.InformationDtos.InformationNewDto;
import com.example.marketplace.dto.InformationDtos.InformationUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IInformationServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements IInformationServices {
    @Override
    public SuccessDto addInformation(InformationNewDto informationNewDto) {
        return null;
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
