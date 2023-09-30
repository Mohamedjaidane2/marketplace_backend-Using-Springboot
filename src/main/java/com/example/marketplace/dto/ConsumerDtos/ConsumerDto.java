package com.example.marketplace.dto.ConsumerDtos;

import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ConsumerDto {

    private Integer id;

    private String pseudo;

    private Date creationDate;

    private String email;

    private List<FeedBackDto> feedBacks;

    private AccountDto account;

    private HistoryDto history;

    @Override
    public String toString() {
        return "ConsumerDto{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", creationDate=" + creationDate +
                ", email='" + email + '\'' +
                ", feedBacks=" + feedBacks +
                ", account=" + account +
                ", history=" + history +
                '}';
    }
    public static ConsumerDto customMapping (Consumer consumer){
        return ConsumerDto.builder()
                .id(consumer.getId())
                .pseudo(consumer.getPseudo())
                .creationDate(consumer.getCreationDate())
                .email(consumer.getEmail())
                .feedBacks(FeedBackDto.customListMapping(consumer.getFeedBacks()))
                .account(AccountDto.customMapping(consumer.getAccount()))
                .history(HistoryDto.customMapping(consumer.getHistory()))
                .build();
    }

    public static List<ConsumerDto> customListMapping (List<Consumer> consumers){
        if(consumers==null) return null;
        ArrayList<ConsumerDto> consumerDtoArrayList = new ArrayList<>();
        for (Consumer consumer : consumers){
            ConsumerDto consumerDto = customMapping(consumer);
            consumerDtoArrayList.add(consumerDto);
        }
        return consumerDtoArrayList;
    }
}
