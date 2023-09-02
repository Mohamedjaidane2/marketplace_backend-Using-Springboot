package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.AddressDto;
import com.example.marketplace.dto.entitiesDto.AdvertisementDto;
import com.example.marketplace.dto.entitiesDto.RequestedDiscountDto;

import java.util.List;

public interface IAdvertisementService {
    SuccessDto postAdvertisement(AdvertisementDto advertisementDto);

    SuccessDto updateAdvertisement(AdvertisementDto advertisementDto);


    AdvertisementDto getAdvertisementById(String advertismentId);

    List<AdvertisementDto> getAdvertismentByAccount(AccountDto accountDto);

    List<AdvertisementDto> getAllAdvertisement();

    List<AdvertisementDto> getMyFeedList(AccountDto accountDto);

    SuccessDto deleteAdvertisement(Integer advertismentId );

    SuccessDto acceptDiscount(RequestedDiscountDto requestedDiscountDto );

    SuccessDto declineDiscount(RequestedDiscountDto requestedDiscountDto);
}
