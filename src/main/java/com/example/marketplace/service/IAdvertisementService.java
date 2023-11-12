package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementNewDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementUpdateDtos;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IAdvertisementService {
    SuccessDto postAdvertisement(AdvertisementNewDto advertisementNewDto);

    SuccessDto updateAdvertisement(AdvertisementUpdateDtos advertisementUpdateDto,Integer advertisementId);


    AdvertisementDto getAdvertisementById(Integer advertisementId);

    List<AdvertisementDto> getAdvertisementByAccount(Integer accountId);

    List<AdvertisementDto> getAllAdvertisement();

    List<AdvertisementDto> getMyFeedList(AccountDto accountDto);

    SuccessDto deleteAdvertisement(Integer advertisementId );
}
