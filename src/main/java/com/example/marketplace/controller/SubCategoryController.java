package com.example.marketplace.controller;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryNewDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.ISubCategoryServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/subcategories")
@RequestMapping("/api/subcategories")
@RestController
@RequiredArgsConstructor
public class SubCategoryController {
    private final ISubCategoryServices subCategoryService;

    @PostMapping("/create")
    @ApiOperation(value = "Create subcategory")
    public ResponseEntity<SuccessDto> createSubCategory(@RequestBody SubCategoryNewDto subCategoryNewDto) {
        return ResponseEntity.ok(subCategoryService.createSubCategory(subCategoryNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update subcategory")
    public ResponseEntity<SuccessDto> updateSubCategory(@RequestBody SubCategoryUpdateDto subCategoryUpdateDto,Integer subCategoryId) {
        return ResponseEntity.ok(subCategoryService.updateSubCategory(subCategoryUpdateDto,subCategoryId));
    }

    @GetMapping("/{subCategoryId}")
    @ApiOperation(value = "Get subcategory by ID")
    public ResponseEntity<SubCategoryDto> getSubCategoryById(@PathVariable Integer subCategoryId) {
        SubCategoryDto subCategoryDto = subCategoryService.getSubCategoryById(subCategoryId);
        return ResponseEntity.ok(subCategoryDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all subcategories")
    public ResponseEntity<List<SubCategoryDto>> getAllSubCategories() {
        List<SubCategoryDto> subCategoryList = subCategoryService.getAllSubCategories();
        return ResponseEntity.ok(subCategoryList);
    }

    @DeleteMapping("/delete/{subCategoryId}")
    @ApiOperation(value = "Delete subcategory by ID")
    public ResponseEntity<SuccessDto> deleteSubCategoryById(@PathVariable Integer subCategoryId) {
        return ResponseEntity.ok(subCategoryService.deleteSubCategoryById(subCategoryId));
    }
}
