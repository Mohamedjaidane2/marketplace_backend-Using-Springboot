package com.example.marketplace.service;

import com.example.marketplace.dto.FavoritesDtos.FavoritesDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IFavoritesServices {
    SuccessDto addToFavorites(Integer advertisementId, Integer accountId);

    SuccessDto removeFromFavorites(Integer favoriteId);

    List<FavoritesDto> getFavoritesByAccountId(Integer accountId);

    List<FavoritesDto> getAllFavorites();
}
