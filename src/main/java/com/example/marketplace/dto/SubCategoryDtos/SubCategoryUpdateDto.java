package com.example.marketplace.dto.SubCategoryDtos;

import com.example.marketplace.dto.BrandDtos.BrandDto;
import com.example.marketplace.dto.CategoryDtos.CategoryDto;
import com.example.marketplace.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SubCategoryUpdateDto {

    private String subCategoryName;

    private Integer categoryId;
}
