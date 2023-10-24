package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestNewDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IDiscountRequestServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountRequestServiceImpl implements IDiscountRequestServices {
    @Override
    public SuccessDto sendDiscount(DiscountRequestNewDto discountRequestNewDto) {
        return null;
    }

    @Override
    public SuccessDto counterDiscount(DiscountRequestNewDto discountRequestNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateDiscount(DiscountRequestUpdateDto discountRequestUpdateDto) {
        return null;
    }

    @Override
    public DiscountRequestDto getDiscountById(String discountId) {
        return null;
    }

    @Override
    public List<DiscountRequestDto> getAllDiscount() {
        return null;
    }

    @Override
    public SuccessDto deleteDiscountRequestById(String categoryId) {
        return null;
    }
}
