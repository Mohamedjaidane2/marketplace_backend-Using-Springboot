package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.ProductDtos.ProductDto;
import com.example.marketplace.dto.ProductDtos.ProductNewDto;
import com.example.marketplace.dto.ProductDtos.ProductUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IProductServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductServices {
    @Override
    public SuccessDto addProduct(ProductNewDto productNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateProduct(ProductUpdateDto productUpdateDto) {
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
