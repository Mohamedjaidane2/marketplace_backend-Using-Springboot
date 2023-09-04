package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.AdvertisementDto;
import com.example.marketplace.dto.entitiesDto.DiscountRequestDto;
import com.example.marketplace.service.IAdvertisementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements IAdvertisementService {
    @Override
    public SuccessDto postAdvertisement(AdvertisementDto advertisementDto) {
        return null;
    }

    @Override
    public SuccessDto updateAdvertisement(AdvertisementDto advertisementDto) {
        return null;
    }

    @Override
    public AdvertisementDto getAdvertisementById(String advertismentId) {
        return null;
    }

    @Override
    public List<AdvertisementDto> getAdvertismentByAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public List<AdvertisementDto> getAllAdvertisement() {
        return null;
    }

    @Override
    public List<AdvertisementDto> getMyFeedList(AccountDto accountDto) {
        return null;
    }

    @Override
    public SuccessDto deleteAdvertisement(Integer advertismentId) {
        return null;
    }

    @Override
    public SuccessDto acceptDiscount(DiscountRequestDto discountRequestDto) {
        return null;
    }

    @Override
    public SuccessDto declineDiscount(DiscountRequestDto discountRequestDto) {
        return null;
    }
}
