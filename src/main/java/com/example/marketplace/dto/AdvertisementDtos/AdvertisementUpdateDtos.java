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
public class AdvertisementUpdateDtos {

    private String title;

    private String description;

    private Integer accountId;

    private Integer productId;

    private EAdvertisementStats advertisementStats;

    private EAdvertisementSoldStats advertisementSoldStats;

    private Float price;

    private Float oldPrice;

}
