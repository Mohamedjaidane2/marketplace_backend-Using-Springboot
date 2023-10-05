package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.service.IWalletServices;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements IWalletServices {
    @Override
    public SuccessDto createWallet(String userId) {
        return null;
    }

    @Override
    public WalletDto getWalletBalance(String userId) {
        return null;
    }

    @Override
    public SuccessDto addFundsToWallet(String userId, double amount) {
        return null;
    }

    @Override
    public SuccessDto makePayment(String userId, double amount) {
        return null;
    }

    @Override
    public SuccessDto withdrawFunds(String userId, double amount) {
        return null;
    }
}
