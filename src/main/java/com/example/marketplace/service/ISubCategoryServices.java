package com.example.marketplace.service;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryNewDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface ISubCategoryServices {

    SuccessDto createSubCategory(SubCategoryNewDto subCategoryNewDto);

    SuccessDto updateSubCategory(SubCategoryUpdateDto subCategoryUpdateDto,Integer subCategoryId);

    List<SubCategoryDto> getAllSubCategories();

    SubCategoryDto getSubCategoryById(Integer subCategoryId);

    SuccessDto deleteSubCategoryById(Integer subCategoryId);
}
