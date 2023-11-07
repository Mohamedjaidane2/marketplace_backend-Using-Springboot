package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryNewDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.SubCategory;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.repository.ICategoryRepository;
import com.example.marketplace.repository.ISubCategoryRepository;
import com.example.marketplace.service.ISubCategoryServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements ISubCategoryServices {
    private final ISubCategoryRepository subCategoryRepository;

    private final ICategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public SuccessDto createSubCategory(SubCategoryNewDto subCategoryNewDto) {
        Optional<Category> category = categoryRepository.findById(subCategoryNewDto.getCategoryId());
        SubCategory subCategory = SubCategory.builder()
                .subCategoryName(subCategoryNewDto.getSubCategoryName())
                .category(category.get())
                .build();

        subCategoryRepository.save(subCategory);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateSubCategory(SubCategoryUpdateDto subCategoryUpdateDto, Integer subCategoryId) {
        SubCategory subCategory = subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new EntityNotFoundException("SubCategory not found", ErrorCodes.SUBCATEGORY_NOT_FOUND));

        modelMapper.map(subCategoryUpdateDto, subCategory);
        subCategoryRepository.save(subCategory);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        return subCategoryRepository.findAll()
                .stream()
                .map(SubCategoryDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryDto getSubCategoryById(Integer subCategoryId) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(subCategoryId);
        if (subCategory.isEmpty()) {
            throw new EntityNotFoundException("SubCategory not found", ErrorCodes.SUBCATEGORY_NOT_FOUND);
        }
        return SubCategoryDto.customMapping(subCategory.get());
    }

    @Override
    public SuccessDto deleteSubCategoryById(Integer subCategoryId) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(subCategoryId);
        if (subCategory.isEmpty()) {
            throw new EntityNotFoundException("SubCategory not found", ErrorCodes.SUBCATEGORY_NOT_FOUND);
        }
        subCategoryRepository.delete(subCategory.get());
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_DELETED)
                .build();
    }
}
