package com.example.marketplace.dto.RequestOrderDtos;

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
public class RequestOrderNewDto {

    private AdvertisementDto advertisement;

    private Date requestDate;
}
