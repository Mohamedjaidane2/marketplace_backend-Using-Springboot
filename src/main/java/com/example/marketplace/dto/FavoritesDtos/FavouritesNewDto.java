package com.example.marketplace.dto.FavoritesDtos;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FavouritesNewDto {

    private AccountDto account;

    private AdvertisementDto advertisement;
}
