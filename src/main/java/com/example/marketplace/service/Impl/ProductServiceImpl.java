package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.ProductDto;
import com.example.marketplace.service.IProductServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductServices {
    @Override
    public SuccessDto addProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public SuccessDto updateProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto getProductById(String productId) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        return null;
    }

    @Override
    public SuccessDto deleteProductById(String productId) {
        return null;
    }
}
