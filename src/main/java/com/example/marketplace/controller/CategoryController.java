package com.example.marketplace.controller;

import com.example.marketplace.dto.CategoryDtos.CategoryDto;
import com.example.marketplace.dto.CategoryDtos.CategoryNewDto;
import com.example.marketplace.dto.CategoryDtos.CategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.ICategoryServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/category")
@RequestMapping("/api/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryServices categoryService;

    @PostMapping("/add")
    @ApiOperation(value = "Add category")
    public ResponseEntity<SuccessDto> addCategory(@RequestBody CategoryNewDto categoryNewDto) {
        return ResponseEntity.ok(categoryService.addCategory(categoryNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update category")
    public ResponseEntity<SuccessDto> updateCategory(@RequestBody CategoryUpdateDto categoryUpdateDto,Integer categoryId) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryUpdateDto,categoryId));
    }

    @GetMapping("/{categoryId}")
    @ApiOperation(value = "Get category by ID")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getAllCategory();
        return ResponseEntity.ok(categoryList);
    }

    @DeleteMapping("/delete/{categoryId}")
    @ApiOperation(value = "Delete category by ID")
    public ResponseEntity<SuccessDto> deleteCategoryById(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(categoryService.deleteCategoryById(categoryId));
    }
}
