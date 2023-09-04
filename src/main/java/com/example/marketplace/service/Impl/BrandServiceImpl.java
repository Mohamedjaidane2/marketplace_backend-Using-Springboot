package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;
import com.example.marketplace.dto.entitiesDto.BrandDto;
import com.example.marketplace.service.IBrandServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandServices {
    @Override
    public SuccessDto addBrand(BrandDto brandDto) {
        return null;
    }

    @Override
    public SuccessDto updateBrand(BrandDto brandDto) {
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
