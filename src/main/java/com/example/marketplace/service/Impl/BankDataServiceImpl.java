package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.BankDataDtos.BankDataDto;
import com.example.marketplace.dto.BankDataDtos.BankDataNewDto;
import com.example.marketplace.dto.BankDataDtos.BankDataUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IBankDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankDataServiceImpl implements IBankDataService {
    @Override
    public SuccessDto addBankData(BankDataNewDto bankDataNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateBankData(BankDataUpdateDto bankDataUpdateDto) {
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
