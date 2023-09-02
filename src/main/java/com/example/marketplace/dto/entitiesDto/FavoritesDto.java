package com.example.marketplace.dto.entitiesDto;

import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Advertisement;
import com.example.marketplace.entity.Consumer;
import com.example.marketplace.entity.Favorites;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FavoritesDto {

    private int favoritesId;

    private AccountDto account;

    private AdvertisementDto advertisement;

    @Override
    public String toString() {
        return "FavoritesDto{" +
                "favoritesId=" + favoritesId +
                ", account=" + account +
                ", advertisement=" + advertisement +
                '}';
    }
    public static FavoritesDto customMapping (Favorites favorites){
        return FavoritesDto.builder()
                .favoritesId(favorites.getFavoritesId())
                .account(AccountDto.customMapping(favorites.getAccount()))
                .advertisement(AdvertisementDto.customMapping(favorites.getAdvertisement()))
                .build();
    }

    public static List<FavoritesDto> customListMapping (List<Favorites> favorites){
        if(favorites==null) return null;
        ArrayList<FavoritesDto> favoritesDtoArrayList = new ArrayList<>();
        for (Favorites favorite : favorites){
            FavoritesDto favoritesDto = customMapping(favorite);
            favoritesDtoArrayList.add(favoritesDto);
        }
        return favoritesDtoArrayList;
    }
}
