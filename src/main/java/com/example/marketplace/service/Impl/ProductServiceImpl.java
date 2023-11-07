package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.ProductDtos.ProductDto;
import com.example.marketplace.dto.ProductDtos.ProductNewDto;
import com.example.marketplace.dto.ProductDtos.ProductUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Information;
import com.example.marketplace.entity.Product;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.repository.IProductRepository;
import com.example.marketplace.service.IProductServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductServices {
    private final IProductRepository iProductRepository;
    private final ModelMapper modelMapper;
    @Override
    public SuccessDto addProduct(ProductNewDto productNewDto) {
        Product product=Product.builder()
                .category(productNewDto.getCategory())
                .images(productNewDto.getImages())
                .ProductStatus(productNewDto.getProductStatus())
                .color(productNewDto.getColor())
                .features(productNewDto.getFeatures())
                .eGender(productNewDto.getEGender())
                .build();
        iProductRepository.save(product);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateProduct(ProductUpdateDto productUpdateDto, Integer productId) {
        Product product = iProductRepository.findById(productId)
        .orElseThrow(()->new EntityNotFoundException("Product not found",ErrorCodes.PRODUCT_NOT_FOUND));

        modelMapper.map(productUpdateDto, product);
        iProductRepository.save(product);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public ProductDto getProductById(Integer productId) {

        Optional<Product> product = iProductRepository.findById(productId);
        if (product.isEmpty()) {
            throw new EntityNotFoundException("Information not found", ErrorCodes.INFORMATION_NOT_FOUND);
        }
        return ProductDto.customMapping(product.get());
    }

    @Override
    public List<ProductDto> getAllProduct() {
        return iProductRepository.findAll()
                .stream()
                .map(ProductDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteProductById(Integer productId) {

        Optional<Product> product = iProductRepository.findById(productId);
        if(product.isEmpty())
            throw new EntityNotFoundException("product not found!",ErrorCodes.PRODUCT_NOT_FOUND);
        iProductRepository.delete(product.get());
        return SuccessDto
                .builder()
                .message(SuccessMessage.SUCCESSFULLY_DELETED)
                .build();
    }
}
