package com.example.marketplace.dto.ProductDtos;

import com.example.marketplace.Enum.EColor;
import com.example.marketplace.Enum.EGender;
import com.example.marketplace.Enum.EProductStatus;
import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.Order;
import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.SubCategory;
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
public class ProductDto {

    private int id;


    private String subCategoryname;

//    private List<String> images;

    private EProductStatus ProductStatus;

    private EColor color;

    private String features;

    private EGender eGender;

    private Date creationDate;

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
//                ", images=" + images +
                ", ProductStatus=" + ProductStatus +
                ", color=" + color +
                ", features='" + features + '\'' +
                ", eGender=" + eGender +
                ", creationDate=" + creationDate +
                '}';
    }
    public static ProductDto customMapping (Product product){
        return ProductDto.builder()
                .id(product.getId())
                .subCategoryname(product.getSubCategory().getSubCategoryName())
//                .images(product.getImages())
                .ProductStatus(product.getProductStatus())
                .color(product.getColor())
                .features(product.getFeatures())
                .eGender(product.getEGender())
                .creationDate(product.getCreationDate())
                .build();
    }
}
