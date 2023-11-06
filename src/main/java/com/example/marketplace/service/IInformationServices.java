package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.InformationDtos.InformationNewDto;
import com.example.marketplace.dto.InformationDtos.InformationUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IInformationServices {
    SuccessDto addInformation(InformationNewDto informationNewDto);

    SuccessDto updateInformation(InformationUpdateDto informationUpdateDto ,Integer infoId);


    InformationDto getInformationById(Integer informationId);

    List<InformationDto> getAllInformation();

    SuccessDto deleteInformationById(Integer informationId);
}
