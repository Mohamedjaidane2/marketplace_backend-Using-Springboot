package com.example.marketplace.controller;

import com.example.marketplace.dto.SalesDtos.SalesDto;
import com.example.marketplace.dto.SalesDtos.SalesNewDto;
import com.example.marketplace.dto.SalesDtos.SalesUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.ISalesServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/sales")
@RequestMapping("/api/sales")
@RestController
@RequiredArgsConstructor
public class SalesController {
    private final ISalesServices salesService;

    @PostMapping("/add")
    @ApiOperation(value = "Add sale")
    public ResponseEntity<SuccessDto> addSales(@RequestBody SalesNewDto salesNewDto) {
        return ResponseEntity.ok(salesService.addSales(salesNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update sale")
    public ResponseEntity<SuccessDto> updateSales(@RequestBody SalesUpdateDto salesUpdateDto) {
        return ResponseEntity.ok(salesService.updateSales(salesUpdateDto));
    }

    @GetMapping("/{saleId}")
    @ApiOperation(value = "Get sale by ID")
    public ResponseEntity<SalesDto> getSaleById(@PathVariable String saleId) {
        SalesDto salesDto = salesService.getSaleById(saleId);
        return ResponseEntity.ok(salesDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all sales")
    public ResponseEntity<List<SalesDto>> getAllSales() {
        List<SalesDto> salesList = salesService.getAllSales();
        return ResponseEntity.ok(salesList);
    }

    @DeleteMapping("/delete/{saleId}")
    @ApiOperation(value = "Delete sale by ID")
    public ResponseEntity<SuccessDto> deleteSaleById(@PathVariable String saleId) {
        return ResponseEntity.ok(salesService.deleteSaleById(saleId));
    }
}
