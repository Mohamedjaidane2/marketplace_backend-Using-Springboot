package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.BrandDtos.BrandDto;
import com.example.marketplace.dto.BrandDtos.BrandNewDto;
import com.example.marketplace.dto.BrandDtos.BrandUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IBrandServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandServices {
    @Override
    public SuccessDto addBrand(BrandNewDto brandNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateBrand(BrandUpdateDto brandUpdateDto) {
        return null;
    }

    @Override
    public BrandDto getBrandById(String brandId) {
        return null;
    }

    @Override
    public List<BrandDto> getAllBrand() {
        return null;
    }

    @Override
    public SuccessDto deleteBrandById(String brandId) {
        return null;
    }
}
