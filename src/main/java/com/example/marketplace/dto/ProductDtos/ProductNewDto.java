package com.example.marketplace.dto.ProductDtos;

import com.example.marketplace.Enum.EColor;
import com.example.marketplace.Enum.EGender;
import com.example.marketplace.Enum.EProductStatus;
import com.example.marketplace.entity.Category;
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
public class ProductNewDto {

    private Category category;

    private List<String> images;

    private EProductStatus ProductStatus;

    private EColor color;

    private String features;

    private EGender eGender;

    private Date creationDate;
}
