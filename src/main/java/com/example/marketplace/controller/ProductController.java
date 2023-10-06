package com.example.marketplace.controller;

import com.example.marketplace.dto.ProductDtos.ProductDto;
import com.example.marketplace.dto.ProductDtos.ProductNewDto;
import com.example.marketplace.dto.ProductDtos.ProductUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IProductServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/product")
@RequestMapping("/api/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final IProductServices productService;

    @PostMapping("/create")
    @ApiOperation(value = "Create product")
    public ResponseEntity<SuccessDto> createProduct(@RequestBody ProductNewDto productNewDto) {
        return ResponseEntity.ok(productService.addProduct(productNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update product")
    public ResponseEntity<SuccessDto> updateProduct(@RequestBody ProductUpdateDto productUpdateDto) {
        return ResponseEntity.ok(productService.updateProduct(productUpdateDto));
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "Get product by ID")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String productId) {
        ProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/delete/{productId}")
    @ApiOperation(value = "Delete product by ID")
    public ResponseEntity<SuccessDto> deleteProductById(@PathVariable String productId) {
        return ResponseEntity.ok(productService.deleteProductById(productId));
    }
}
