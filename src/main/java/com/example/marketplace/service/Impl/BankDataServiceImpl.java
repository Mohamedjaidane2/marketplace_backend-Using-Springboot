package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;
import com.example.marketplace.service.IBankDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankDataServiceImpl implements IBankDataService {
    @Override
    public SuccessDto addBankData(BankDataDto bankDataDto) {
        return null;
    }

    @Override
    public SuccessDto updateBankData(BankDataDto bankDataDto) {
        return null;
    }

    @Override
    public BankDataDto getBankDataById(String bankDataId) {
        return null;
    }

    @Override
    public BankDataDto getBankDataByAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public List<BankDataDto> getAllBankData() {
        return null;
    }

    @Override
    public SuccessDto deleteBankDataById(String bankDataId) {
        return null;
    }
}
