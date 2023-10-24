package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.HistoryDtos.HistoryDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;


public interface IHistoryServices {

    SuccessDto addHistory(HistoryDto historyDto);

    HistoryDto getHistoryById(String historyId);

    HistoryDto getHistoryByAccount(AccountDto historyDto);

    SuccessDto deleteHistoryById(String historyId);
}
