package com.example.marketplace.service;

import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestNewDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateCounterDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IDiscountRequestServices {

    SuccessDto sendDiscount(Integer accountId, Integer advertisementId,DiscountRequestNewDto discountRequestNewDto);

    SuccessDto counterDiscount(Integer discountRequestId, DiscountRequestUpdateCounterDto discountRequestUpdateDto);

    SuccessDto updateDiscount(Integer discountRequestId,DiscountRequestUpdateDto discountRequestUpdateDto);

    DiscountRequestDto getDiscountById(Integer discountId);

    List<DiscountRequestDto> getAllDiscount();

    SuccessDto deleteDiscountRequestById(Integer discountId);

    List<DiscountRequestDto> getDiscountByAccountId(Integer accountId);

    List<DiscountRequestDto> getDiscountByAdvertisementOwnerId(Integer advertisementOwnerId);

    SuccessDto acceptDiscount(Integer discountId);

    SuccessDto declineDiscount(Integer discountId);
}
