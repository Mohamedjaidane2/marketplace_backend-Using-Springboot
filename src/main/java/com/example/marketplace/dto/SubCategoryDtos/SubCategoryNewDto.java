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
public class SubCategoryNewDto {

    private String subCategoryName;

    private CategoryDto category;

    private List<BrandDto> brands;

    private List<Tag> tags;

    private Date creationDate;
}
