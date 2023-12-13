package com.example.marketplace.dto.AdvertisementDtos;


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

    private Integer accountId;

    private Integer productId;

    private Double price;
}
