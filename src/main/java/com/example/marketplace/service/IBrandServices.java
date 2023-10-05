package com.example.marketplace.service;

import com.example.marketplace.dto.BrandDtos.BrandDto;
import com.example.marketplace.dto.BrandDtos.BrandNewDto;
import com.example.marketplace.dto.BrandDtos.BrandUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IBrandServices {
    SuccessDto addBrand(BrandNewDto brandNewDto);

    SuccessDto updateBrand(BrandUpdateDto brandUpdateDto);


    BrandDto getBrandById(String brandId);


    List<BrandDto> getAllBrand();

    SuccessDto deleteBrandById(String brandId);
}
