package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;
import com.example.marketplace.dto.entitiesDto.BrandDto;
import com.example.marketplace.dto.entitiesDto.InformationDto;

import java.util.List;

public interface IInformationServices {
    SuccessDto addInformation(InformationDto informationDto);

    SuccessDto updateInformation(InformationDto informationDto);


    InformationDto getInformationById(String informationId);

    InformationDto getInformationByAccount(AccountDto accountDto);

    List<InformationDto> getAllInformation();

    SuccessDto deleteInformationById(String informationId);
}
