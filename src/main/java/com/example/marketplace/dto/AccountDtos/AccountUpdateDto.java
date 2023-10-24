package com.example.marketplace.dto.AccountDtos;

import com.example.marketplace.Enum.ESellerLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountUpdateDto {

    private ESellerLevel sellerLevel;

}
