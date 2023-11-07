package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.BrandDtos.BrandDto;
import com.example.marketplace.dto.BrandDtos.BrandNewDto;
import com.example.marketplace.dto.BrandDtos.BrandUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Brand;
import com.example.marketplace.entity.SubCategory;
import com.example.marketplace.entity.Tag;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.IBrandRepository;
import com.example.marketplace.repository.ISubCategoryRepository;
import com.example.marketplace.service.IBrandServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements IBrandServices {
    private final IBrandRepository iBrandRepository;
    private final ModelMapper modelMapper;
    private final ISubCategoryRepository subCategoryRepository;

    @Override
    public SuccessDto addBrand(BrandNewDto brandNewDto) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(brandNewDto.getSubcategoryId());

        if (subCategory.isEmpty()) {
            throw new EntityNotFoundException("SubCategory not found", ErrorCodes.SUBCATEGORY_NOT_FOUND);
        }

        String brandName = brandNewDto.getBrandName();
        // Check if the brand name already exists in the database
        Optional<Brand> existingBrand = iBrandRepository.findByBrandName(brandName);

        if (existingBrand.isPresent()) {
            throw new InvalidOperationException("Brand name already exists", ErrorCodes.TAG_ALREADY_IN_USE);
        }

        Brand brand = Brand.builder()
                .brandName(brandName)
                .subcategory(subCategory.get())
                .build();

        iBrandRepository.save(brand);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }


    @Override
    public SuccessDto updateBrand(BrandUpdateDto brandUpdateDto,Integer brandId) {

        Brand brand = iBrandRepository.findById(brandId)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found", ErrorCodes.BRAND_NOT_FOUND));
        Optional<SubCategory> subCategory=subCategoryRepository.findById(brandUpdateDto.getSubcategoryId());
        modelMapper.map(brandUpdateDto, brand);

        brand.setSubcategory(subCategory.get());
        iBrandRepository.save(brand);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public BrandDto getBrandById(Integer brandId) {
        Optional<Brand> brand = iBrandRepository.findById(brandId);
        if (brand.isEmpty()) {
            throw new EntityNotFoundException("Brand not found", ErrorCodes.BRAND_NOT_FOUND);
        }
        return BrandDto.customMapping(brand.get());
    }

    @Override
    public List<BrandDto> getAllBrand() {
        return iBrandRepository.findAll()
                .stream()
                .map(BrandDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteBrandById(Integer brandId) {
        Optional<Brand> brand = iBrandRepository.findById(brandId);
        if (brand.isEmpty()) {
            throw new EntityNotFoundException("Brand not found", ErrorCodes.BRAND_NOT_FOUND);
        }
        iBrandRepository.delete(brand.get());
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_DELETED)
                .build();
    }
}
