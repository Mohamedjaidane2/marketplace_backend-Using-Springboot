package com.example.marketplace.dto.WalletDtos;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Transaction;
import com.example.marketplace.entity.User;
import com.example.marketplace.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WalletDto {

    private Integer wallet_id;

    private double balance;

    private Integer accountId;

    private List<TransactionDto> transactions;

    @Override
    public String toString() {
        return "WalletDto{" +
                "wallet_id=" + wallet_id +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }

    public static WalletDto customMapping (Wallet wallet){
        return WalletDto.builder()
                .wallet_id(wallet.getWallet_id())
                .balance(wallet.getBalance())
                .accountId(wallet.getAccount().getAccountId())
                .transactions(TransactionDto.customListMapping(wallet.getTransactions()))
                .build();
    }

}
