package com.example.marketplace.dto.SubCategoryDtos;

import com.example.marketplace.dto.BrandDtos.BrandDto;
import com.example.marketplace.dto.TagsDtos.TagsDto;
import com.example.marketplace.entity.*;
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
public class SubCategoryDto {

    private int subCategoryId;

    private int categoryId;

    private String subCategoryName;

    private List<BrandDto> brands;

    private List<TagsDto> tags;

    private Date creationDate;

    public static List<SubCategoryDto> customListMapping(List<SubCategory> subCategories) {
        if(subCategories==null) return null;
        ArrayList<SubCategoryDto> subCategoryDtoArrayList = new ArrayList<>();
        for (SubCategory subCategory : subCategories){
            SubCategoryDto subCategoryDto = customMapping(subCategory);
            subCategoryDtoArrayList.add(subCategoryDto);
        }
        return subCategoryDtoArrayList;
    }


    @Override
    public String toString() {
        return "SubCategoryDto{" +
                "subCategoryId=" + subCategoryId +
                "categoryId=" + categoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", brands=" + brands +
                ", tags=" + tags +
                ", creationDate=" + creationDate +
                '}';
    }

    public static SubCategoryDto customMapping (SubCategory subCategory){
        return SubCategoryDto.builder()
                .subCategoryId(subCategory.getSubCategoryId())
                .categoryId(subCategory.getCategory().getCategoryId())
                .brands(BrandDto.customListMapping(subCategory.getBrands()))
                .subCategoryName(subCategory.getSubCategoryName())
                .tags(TagsDto.customListMapping(subCategory.getTags()))
                .creationDate(subCategory.getCreationDate())
                .build();
    }
}
