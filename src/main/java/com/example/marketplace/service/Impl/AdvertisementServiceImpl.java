package com.example.marketplace.service.Impl;
import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementNewDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementUpdateDtos;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IAdvertisementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements IAdvertisementService {
    @Override
    public SuccessDto postAdvertisement(AdvertisementNewDto advertisementNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateAdvertisement(AdvertisementUpdateDtos advertisementUpdateDto) {
        return null;
    }

    @Override
    public AdvertisementDto getAdvertisementById(String advertisementId) {
        return null;
    }

    @Override
    public List<AdvertisementDto> getAdvertisementByAccount(AccountDto accountDto) {
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
    public SuccessDto deleteAdvertisement(Integer advertisementId) {
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
