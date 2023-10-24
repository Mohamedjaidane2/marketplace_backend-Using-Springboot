package com.example.marketplace.dto.BrandDtos;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BrandUpdateDto {

    private String brandName;

    private SubCategoryDto subcategory;

    private Date creationDate;
}
