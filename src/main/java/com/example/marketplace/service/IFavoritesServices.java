package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AdvertisementDto;
import com.example.marketplace.dto.entitiesDto.ConsumerDto;

public interface IFavoritesServices {
    SuccessDto addToFavorites (Integer favoriteId , AdvertisementDto advertisementDto);

    SuccessDto removeFromFavorites (Integer favoriteId , AdvertisementDto advertisementDto );
}
