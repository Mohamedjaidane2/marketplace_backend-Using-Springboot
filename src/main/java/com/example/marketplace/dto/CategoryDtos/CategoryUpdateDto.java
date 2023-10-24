package com.example.marketplace.dto.CategoryDtos;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
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
public class CategoryUpdateDto {

    private String categoryName;

    private List<SubCategoryDto> subCategories;

    private Date creationDate;
}
