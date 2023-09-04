package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.HistoryDto;


public interface IHistoryServices {

    SuccessDto addHistory(HistoryDto historyDto);

    HistoryDto getHistoryById(String historyId);

    HistoryDto getHistoryByAccount(AccountDto historyDto);

    SuccessDto deleteHistoryById(String historyId);
}
