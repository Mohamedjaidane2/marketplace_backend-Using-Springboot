package com.example.marketplace.service;

import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestNewDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IDiscountRequestServices {

    SuccessDto sendDiscount(DiscountRequestNewDto discountRequestNewDto);

    SuccessDto counterDiscount(DiscountRequestNewDto discountRequestNewDto);

    SuccessDto updateDiscount(DiscountRequestUpdateDto discountRequestUpdateDto);

    DiscountRequestDto getDiscountById(String discountId);

    List<DiscountRequestDto> getAllDiscount();

    SuccessDto deleteDiscountRequestById(String categoryId);
}
