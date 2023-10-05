package com.example.marketplace.dto.HistoryDtos;

import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.entity.History;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HistoryDto {
    private int history_id;

    private AdvertisementDto advertisement;

    @Override
    public String toString() {
        return "HistoryDto{" +
                "history_id=" + history_id +
                ", advertisment=" + advertisement +
                '}';
    }

    public static HistoryDto customMapping (History history){
        return HistoryDto.builder()
                .history_id(history.getHistory_id())
                .advertisement(AdvertisementDto.customMapping(history.getAdvertisment()))
                .build();
    }
}
