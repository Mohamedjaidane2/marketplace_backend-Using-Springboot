package com.example.marketplace.dto.SalesDtos;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SalesUpdateDto {

    private AccountDto account;

    private AdvertisementDto advertisement;

    private Date saleDate;
}
