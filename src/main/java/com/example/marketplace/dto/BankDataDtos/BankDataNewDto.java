package com.example.marketplace.dto.BankDataDtos;


import com.example.marketplace.dto.AccountDtos.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BankDataNewDto {

    private String bankName;

    private String rib;

    private Integer accountId;
}
