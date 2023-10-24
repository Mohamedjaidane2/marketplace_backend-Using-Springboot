package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SalesDtos.SalesDto;
import com.example.marketplace.dto.SalesDtos.SalesNewDto;
import com.example.marketplace.dto.SalesDtos.SalesUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.ISalesServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements ISalesServices{
    @Override
    public SuccessDto addSales(SalesNewDto salesNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateSales(SalesUpdateDto salesUpdateDto) {
        return null;
    }

    @Override
    public List<SalesDto> getAllSales() {
        return null;
    }

    @Override
    public SalesDto getSaleById(String saleId) {
        return null;
    }

    @Override
    public SuccessDto deleteSaleById(String saleId) {
        return null;
    }
}
