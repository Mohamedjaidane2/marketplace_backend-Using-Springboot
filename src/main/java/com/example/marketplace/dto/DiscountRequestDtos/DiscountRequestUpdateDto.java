package com.example.marketplace.dto.DiscountRequestDtos;

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
public class DiscountRequestUpdateDto {

    private AccountDto account;

    private AdvertisementDto advertisement;

    private Float requestedAmount;

    private Date requestDate;
}
