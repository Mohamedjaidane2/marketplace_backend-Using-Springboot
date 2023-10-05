package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.CategoryDtos.CategoryDto;
import com.example.marketplace.dto.CategoryDtos.CategoryNewDto;
import com.example.marketplace.dto.CategoryDtos.CategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.ICategoryServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryServices {
    @Override
    public SuccessDto addCategory(CategoryNewDto categoryNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateCategory(CategoryUpdateDto categoryUpdateDto) {
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
