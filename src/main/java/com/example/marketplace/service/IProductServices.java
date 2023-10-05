package com.example.marketplace.service;

import com.example.marketplace.dto.ProductDtos.ProductDto;
import com.example.marketplace.dto.ProductDtos.ProductNewDto;
import com.example.marketplace.dto.ProductDtos.ProductUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IProductServices {

    SuccessDto addProduct(ProductNewDto productNewDto);

    SuccessDto updateProduct(ProductUpdateDto productUpdateDto );


    ProductDto getProductById(String productId);

    List<ProductDto> getAllProduct();

    SuccessDto deleteProductById(String productId);
}
