package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;
import com.example.marketplace.dto.entitiesDto.CategoryDto;
import com.example.marketplace.service.ICategoryServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryServices {
    @Override
    public SuccessDto addCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public SuccessDto updateCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(String categoryId) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return null;
    }

    @Override
    public SuccessDto deleteCategoryById(String categoryId) {
        return null;
    }
}
