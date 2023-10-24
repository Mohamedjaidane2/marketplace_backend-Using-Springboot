package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.HistoryDtos.HistoryDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IHistoryServices;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements IHistoryServices {
    @Override
    public SuccessDto addHistory(HistoryDto historyDto) {
        return null;
    }

    @Override
    public HistoryDto getHistoryById(String historyId) {
        return null;
    }

    @Override
    public HistoryDto getHistoryByAccount(AccountDto historyDto) {
        return null;
    }

    @Override
    public SuccessDto deleteHistoryById(String historyId) {
        return null;
    }
}
