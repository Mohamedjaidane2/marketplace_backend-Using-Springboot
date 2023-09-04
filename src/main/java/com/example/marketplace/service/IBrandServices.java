package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;
import com.example.marketplace.dto.entitiesDto.BrandDto;

import java.util.List;

public interface IBrandServices {
    SuccessDto addBrand(BrandDto brandDto);

    SuccessDto updateBrand(BrandDto brandDto);


    BrandDto getBrandById(String brandId);


    List<BrandDto> getAllBrand();

    SuccessDto deleteBrandById(String brandId);
}
