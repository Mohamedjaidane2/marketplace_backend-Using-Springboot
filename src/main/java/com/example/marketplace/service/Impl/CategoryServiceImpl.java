package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.CategoryDtos.CategoryDto;
import com.example.marketplace.dto.CategoryDtos.CategoryNewDto;
import com.example.marketplace.dto.CategoryDtos.CategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Category;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.ICategoryRepository;
import com.example.marketplace.service.ICategoryServices;
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
public class CategoryServiceImpl implements ICategoryServices {
    private final ICategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public SuccessDto addCategory(CategoryNewDto categoryNewDto) {
        Optional<Category> check = categoryRepository.findByCategoryName(categoryNewDto.getCategoryName());
        if(check.isPresent()){
         throw new InvalidOperationException("category already exist ! ",ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        Category category = Category.builder()
                .categoryName(categoryNewDto.getCategoryName())
                .build();
        categoryRepository.save(category);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateCategory(CategoryUpdateDto categoryUpdateDto, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found", ErrorCodes.CATEGORY_NOT_FOUND));
        modelMapper.map(categoryUpdateDto, category);

        categoryRepository.save(category);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty()) {
            throw new EntityNotFoundException("Category not found", ErrorCodes.CATEGORY_NOT_FOUND);
        }
        return CategoryDto.customMapping(category.get());
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteCategoryById(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty()) {
            throw new EntityNotFoundException("Category not found", ErrorCodes.CATEGORY_NOT_FOUND);
        }
        categoryRepository.delete(category.get());

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_REMOVED)
                .build();
    }
}
