package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;

import java.util.List;

public interface IBankDataService {
    SuccessDto addBankData(BankDataDto bankDataDto);

    SuccessDto updateBankData(BankDataDto bankDataDto);


    BankDataDto getBankDataById(String bankDataId);

    BankDataDto getBankDataByAccount(AccountDto accountDto);

    List<BankDataDto> getAllBankData();

    SuccessDto deleteBankDataById(String bankDataId);
}
