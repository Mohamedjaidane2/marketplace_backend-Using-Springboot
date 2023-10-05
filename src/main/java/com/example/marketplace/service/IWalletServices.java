package com.example.marketplace.service;

import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

public interface IWalletServices {

    SuccessDto createWallet(String userId);

    WalletDto getWalletBalance(String userId);

    SuccessDto addFundsToWallet(String userId, double amount);

    SuccessDto makePayment(String userId, double amount);

    SuccessDto withdrawFunds(String userId, double amount);
}
