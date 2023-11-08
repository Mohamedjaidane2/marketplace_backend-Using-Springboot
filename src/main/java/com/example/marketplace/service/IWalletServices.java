package com.example.marketplace.service;

import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.WalletDtos.WalletNewDto;

public interface IWalletServices {

    SuccessDto createWallet(WalletNewDto walletNewDto);

    double getWalletBalance(Integer walletId);
    WalletDto getWalletById(Integer walletId);

    SuccessDto addFundsToWallet(Integer walletId, double amount);

    SuccessDto withdrawFunds(Integer  walletId, double amount);
}
