package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.FeedBackDto;
import com.example.marketplace.dto.entitiesDto.ProductDto;

import java.util.List;

public interface IProductServices {

    SuccessDto addProduct(ProductDto productDto);

    SuccessDto updateProduct(ProductDto productDto );


    ProductDto getProductById(String productId);

    List<ProductDto> getAllProduct();

    SuccessDto deleteProductById(String productId);
}
