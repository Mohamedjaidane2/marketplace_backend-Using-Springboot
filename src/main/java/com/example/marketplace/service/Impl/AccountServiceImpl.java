package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AccountDtos.AccountNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.User;
import com.example.marketplace.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {


    @Override
    public SuccessDto deactivateAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public SuccessDto ReactivateAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountDto getAccountByUser(User user) {
        return null;
    }

    @Override
    public AccountDto getAccountById(Integer id) {
        return null;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return null;
    }
}
