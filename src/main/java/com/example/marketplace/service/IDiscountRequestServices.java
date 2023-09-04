package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.CategoryDto;
import com.example.marketplace.dto.entitiesDto.DiscountRequestDto;

import java.util.List;

public interface IDiscountRequestServices {

    SuccessDto sendDiscount(DiscountRequestDto discountRequestDto);

    SuccessDto counterDiscount(DiscountRequestDto discountRequestDto);

    SuccessDto updateDiscount(DiscountRequestDto discountRequestDto);

    DiscountRequestDto getDiscountById(String discountId);

    List<DiscountRequestDto> getAllDiscount();

    SuccessDto deleteDiscountRequestById(String categoryId);
}
