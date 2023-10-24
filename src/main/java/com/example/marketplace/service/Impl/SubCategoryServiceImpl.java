package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryNewDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.ISubCategoryServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements ISubCategoryServices {
    @Override
    public SuccessDto createSubCategory(SubCategoryNewDto subCategoryNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateSubCategory(SubCategoryUpdateDto subCategoryUpdateDto) {
        return null;
    }

    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        return null;
    }

    @Override
    public SubCategoryDto getSubCategoryById(String subCategoryId) {
        return null;
    }

    @Override
    public SuccessDto deleteSubCategoryById(String subCategoryId) {
        return null;
    }
}
