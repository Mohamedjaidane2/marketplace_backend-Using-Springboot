package com.example.marketplace.service;

import com.example.marketplace.dto.SalesDtos.SalesDto;
import com.example.marketplace.dto.SalesDtos.SalesNewDto;
import com.example.marketplace.dto.SalesDtos.SalesUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import java.util.List;

public interface ISalesServices {

    SuccessDto addSales(SalesNewDto salesNewDto);

    SuccessDto updateSales(SalesUpdateDto salesUpdateDto);

    List<SalesDto> getAllSales();

    SalesDto getSaleById(String saleId);

    SuccessDto deleteSaleById(String saleId);
}
