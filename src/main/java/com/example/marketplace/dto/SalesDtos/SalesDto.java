package com.example.marketplace.dto.SalesDtos;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SalesDto {

    private int salesId;

    private AccountDto account;

    private AdvertisementDto advertisement;

    private Date saleDate;

    public static List<SalesDto> customListMapping(List<Sales> sales) {
        if(sales==null) return null;
        ArrayList<SalesDto> salesDtoArrayList= new ArrayList<>();
        for (Sales sales1 : sales){
            SalesDto salesDto = customMapping(sales1);
            salesDtoArrayList.add(salesDto);
        }
        return salesDtoArrayList;
    }

    @Override
    public String toString() {
        return "SalesDto{" +
                "salesId=" + salesId +
                ", account=" + account +
                ", advertisement=" + advertisement +
                ", saleDate=" + saleDate +
                '}';
    }

    public static SalesDto customMapping (Sales sales){
        return SalesDto.builder()
                .salesId(sales.getSalesId())
                .account(AccountDto.customMapping(sales.getAccount()))
                .saleDate(sales.getSaleDate())
                .advertisement(AdvertisementDto.customMapping(sales.getAdvertisement()))
                .build();
    }
}
