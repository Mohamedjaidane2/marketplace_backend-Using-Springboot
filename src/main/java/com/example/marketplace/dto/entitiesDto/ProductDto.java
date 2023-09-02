package com.example.marketplace.dto.entitiesDto;

import com.example.marketplace.Enum.EColor;
import com.example.marketplace.Enum.EGender;
import com.example.marketplace.Enum.EProductStatus;
import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.Order;
import com.example.marketplace.entity.Product;
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

    private Category category;

    private List<String> images;

    private EProductStatus ProductStatus;

    private EColor color;

    private String features;

    private EGender eGender;

    private Date creationDate;

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", category=" + category +
                ", images=" + images +
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
                .category(product.getCategory())
                .images(product.getImages())
                .ProductStatus(product.getProductStatus())
                .color(product.getColor())
                .features(product.getFeatures())
                .eGender(product.getEGender())
                .creationDate(product.getCreationDate())
                .build();
    }
}
