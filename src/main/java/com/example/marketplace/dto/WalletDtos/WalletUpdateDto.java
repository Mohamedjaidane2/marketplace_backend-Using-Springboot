package com.example.marketplace.dto.WalletDtos;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WalletUpdateDto {

    private Float balance;

    private AccountDto account;

    private List<TransactionDto> transactions;
}
