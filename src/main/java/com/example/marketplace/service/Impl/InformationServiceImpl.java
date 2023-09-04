package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.InformationDto;
import com.example.marketplace.service.IInformationServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements IInformationServices {
    @Override
    public SuccessDto addInformation(InformationDto informationDto) {
        return null;
    }

    @Override
    public SuccessDto updateInformation(InformationDto informationDto) {
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
