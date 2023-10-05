package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.BankDataDtos.BankDataDto;
import com.example.marketplace.dto.BankDataDtos.BankDataNewDto;
import com.example.marketplace.dto.BankDataDtos.BankDataUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IBankDataService {
    SuccessDto addBankData(BankDataNewDto bankDataNewDto);

    SuccessDto updateBankData(BankDataUpdateDto bankDataUpdateDto);


    BankDataDto getBankDataById(String bankDataId);

    BankDataDto getBankDataByAccount(AccountDto accountDto);

    List<BankDataDto> getAllBankData();

    SuccessDto deleteBankDataById(String bankDataId);
}
