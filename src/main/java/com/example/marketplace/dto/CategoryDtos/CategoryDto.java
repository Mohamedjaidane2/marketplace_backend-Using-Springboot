package com.example.marketplace.dto.CategoryDtos;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.dto.SubCategoryDtos.SubCategorySimpleDto;
import com.example.marketplace.entity.Category;
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
public class CategoryDto {

    private int categoryId;

    private String categoryName;

    private List<SubCategorySimpleDto> subCategories;

    private Date creationDate;


    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", subCategories=" + subCategories +
                ", creationDate=" + creationDate +
                '}';
    }
    public static CategoryDto customMapping (Category category){
        return CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .subCategories(SubCategorySimpleDto.customListMapping(category.getSubCategories()))
                .creationDate(category.getCreationDate())
                .build();
    }

    public static List<CategoryDto> customListMapping (List<Category> categories){
        if(categories==null) return null;
        ArrayList<CategoryDto> categoryDtoArrayList = new ArrayList<>();
        for (Category category : categories){
            CategoryDto categoryDto = customMapping(category);
            categoryDtoArrayList.add(categoryDto);
        }
        return categoryDtoArrayList;
    }
}
