package com.example.marketplace.service;

import com.example.marketplace.dto.CategoryDtos.CategoryDto;
import com.example.marketplace.dto.CategoryDtos.CategoryNewDto;
import com.example.marketplace.dto.CategoryDtos.CategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface ICategoryServices {
    SuccessDto addCategory(CategoryNewDto categoryNewDto);

    SuccessDto updateCategory(CategoryUpdateDto categoryUpdateDto,Integer categoryId);


    CategoryDto getCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategory();

    SuccessDto deleteCategoryById(Integer categoryId);
}
