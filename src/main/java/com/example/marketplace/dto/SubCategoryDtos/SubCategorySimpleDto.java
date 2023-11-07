package com.example.marketplace.dto.SubCategoryDtos;

import com.example.marketplace.dto.BrandDtos.BrandDto;
import com.example.marketplace.dto.TagsDtos.TagsDto;
import com.example.marketplace.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SubCategorySimpleDto {


    private int subCategoryId;
    private int categoryId;

    private String subCategoryName;

    private Date creationDate;

    public static List<SubCategorySimpleDto> customListMapping(List<SubCategory> subCategories) {
        if(subCategories==null) return null;
        ArrayList<SubCategorySimpleDto> subCategorySimpleDtoArrayList = new ArrayList<>();
        for (SubCategory subCategory : subCategories){
            SubCategorySimpleDto subCategorySimpleDto = customMapping(subCategory);
            subCategorySimpleDtoArrayList.add(subCategorySimpleDto);
        }
        return subCategorySimpleDtoArrayList;
    }

    @Override
    public String toString() {
        return "SubCategoryDto{" +
                "subCategoryId=" + subCategoryId +
                "categoryId=" + categoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public static SubCategorySimpleDto customMapping (SubCategory subCategory){
        return SubCategorySimpleDto.builder()
                .subCategoryId(subCategory.getSubCategoryId())
                .categoryId(subCategory.getCategory().getCategoryId())
                .subCategoryName(subCategory.getSubCategoryName())
                .creationDate(subCategory.getCreationDate())
                .build();
    }
}
