package com.example.marketplace.dto.OrderDtos;

import com.example.marketplace.Enum.EOrderStatus;
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
public class OrderNewDto {

    private Date orderDate;

    private Float totalPrice;

    private EOrderStatus orderStatus;

    private AdvertisementDto advertisement;

    private AccountDto account;
}
