package com.example.marketplace.dto.TransactionDtos;

import com.example.marketplace.dto.WalletDtos.WalletDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionUpdateDto {

    private Date transaction_date;

    private WalletDto wallet;

    private Float amount;
}
