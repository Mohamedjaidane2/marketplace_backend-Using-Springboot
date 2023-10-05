package com.example.marketplace.dto.ConsumerDtos;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackDto;
import com.example.marketplace.dto.HistoryDtos.HistoryDto;
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
public class ConsumerNewDto {

    private String pseudo;

    private Date creationDate;

    private String email;

    private List<FeedBackDto> feedBacks;

    private AccountDto account;

    private HistoryDto history;
}
