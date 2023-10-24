package com.example.marketplace.service;

import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

public interface IFavoritesServices {
    SuccessDto addToFavorites (Integer favoriteId , AdvertisementDto advertisementDto);

    SuccessDto removeFromFavorites (Integer favoriteId , AdvertisementDto advertisementDto );
}
