package com.example.marketplace.controller;

import com.example.marketplace.dto.BrandDtos.BrandDto;
import com.example.marketplace.dto.BrandDtos.BrandNewDto;
import com.example.marketplace.dto.BrandDtos.BrandUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IBrandServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/brand")
@RequestMapping("/api/brand")
@RestController
@RequiredArgsConstructor
public class BrandController {
    private final IBrandServices brandService;

    @PostMapping("/add")
    @ApiOperation(value = "Add brand")
    public ResponseEntity<SuccessDto> addBrand(@RequestBody BrandNewDto brandNewDto) {
        return ResponseEntity.ok(brandService.addBrand(brandNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update brand")
    public ResponseEntity<SuccessDto> updateBrand(@RequestBody BrandUpdateDto brandUpdateDto,Integer brandId) {
        return ResponseEntity.ok(brandService.updateBrand(brandUpdateDto,brandId));
    }

    @GetMapping("/{brandId}")
    @ApiOperation(value = "Get brand by ID")
    public ResponseEntity<BrandDto> getBrandById(@PathVariable Integer brandId) {
        BrandDto brandDto = brandService.getBrandById(brandId);
        return ResponseEntity.ok(brandDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all brands")
    public ResponseEntity<List<BrandDto>> getAllBrands() {
        List<BrandDto> brandList = brandService.getAllBrand();
        return ResponseEntity.ok(brandList);
    }

    @DeleteMapping("/delete/{brandId}")
    @ApiOperation(value = "Delete brand by ID")
    public ResponseEntity<SuccessDto> deleteBrandById(@PathVariable Integer brandId) {
        return ResponseEntity.ok(brandService.deleteBrandById(brandId));
    }
}
