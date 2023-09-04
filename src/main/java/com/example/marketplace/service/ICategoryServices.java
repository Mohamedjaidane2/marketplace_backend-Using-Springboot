package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;
import com.example.marketplace.dto.entitiesDto.BrandDto;
import com.example.marketplace.dto.entitiesDto.CategoryDto;

import java.util.List;

public interface ICategoryServices {
    SuccessDto addCategory(CategoryDto categoryDto);

    SuccessDto updateCategory(CategoryDto categoryDto);


    CategoryDto getCategoryById(String categoryId);

    List<CategoryDto> getAllCategory();

    SuccessDto deleteCategoryById(String categoryId);
}
