package com.example.marketplace.dto.BrandDtos;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.entity.Brand;
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
public class BrandDto {

    private int brandId;

    private String brandName;

    private Date creationDate;

    @Override
    public String toString() {
        return "BrandDto{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
    public static BrandDto customMapping (Brand brand){
        return BrandDto.builder()
                .brandId(brand.getBrandId())
                .brandName(brand.getBrandName())
                .creationDate(brand.getCreationDate())
                .build();
    }
    public static List<BrandDto> customListMapping(List<Brand> brands){
        if (brands == null) return null;
        ArrayList<BrandDto> brandDtoArrayList = new ArrayList<>();
        for (Brand brand : brands ) {
            BrandDto brandDto = customMapping(brand);
            brandDtoArrayList.add(brandDto);
        }
        return brandDtoArrayList;
    }

}
