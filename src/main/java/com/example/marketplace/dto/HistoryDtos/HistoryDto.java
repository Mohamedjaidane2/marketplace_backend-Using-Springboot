package com.example.marketplace.dto.HistoryDtos;

import com.example.marketplace.entity.Advertisement;
import com.example.marketplace.entity.FeedBack;
import com.example.marketplace.entity.History;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HistoryDto {
    private int history_id;

    private AdvertisementDto advertisment;

    @Override
    public String toString() {
        return "HistoryDto{" +
                "history_id=" + history_id +
                ", advertisment=" + advertisment +
                '}';
    }

    public static HistoryDto customMapping (History history){
        return HistoryDto.builder()
                .history_id(history.getHistory_id())
                .advertisment(AdvertisementDto.customMapping(history.getAdvertisment()))
                .build();
    }
}
