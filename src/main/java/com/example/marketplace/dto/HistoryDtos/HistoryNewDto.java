package com.example.marketplace.dto.HistoryDtos;

import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HistoryNewDto {

    private AdvertisementDto advertisement;
}
