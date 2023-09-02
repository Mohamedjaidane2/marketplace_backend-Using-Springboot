package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.User;

import java.util.List;

public interface IAccountService {
    SuccessDto deactivateAccount(AccountDto accountDto);

    AccountDto getAccountByUser(User user);

    AccountDto getAccountById(Integer id);

    List<AccountDto> getAllAccounts ();

}
