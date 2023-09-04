package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AdvertisementDto;
import com.example.marketplace.service.IFavoritesServices;
import org.springframework.stereotype.Service;

@Service
public class FavoritesServiceImpl implements IFavoritesServices {
    @Override
    public SuccessDto addToFavorites(Integer favoriteId, AdvertisementDto advertisementDto) {
        return null;
    }

    @Override
    public SuccessDto removeFromFavorites(Integer favoriteId, AdvertisementDto advertisementDto) {
        return null;
    }
}
