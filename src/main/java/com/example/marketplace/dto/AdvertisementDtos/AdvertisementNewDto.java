package com.example.marketplace.dto.AdvertisementDtos;

import com.example.marketplace.Enum.EAdvertisementSoldStats;
import com.example.marketplace.Enum.EAdvertisementStats;
import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.dto.ProductDtos.ProductDto;
import com.example.marketplace.dto.RequestOrderDtos.RequestOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdvertisementNewDto {

    private String title;

    private String description;

    private AccountDto account;

    private ProductDto product;

    private EAdvertisementStats advertisementStats;

    private List<OrderDto> orders;

    private Float price;

    private Float oldPrice;

    private List<RequestOrderDto> requestOrders;

    private Date creationDate;
}
