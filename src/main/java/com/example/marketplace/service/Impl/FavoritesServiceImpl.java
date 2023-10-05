package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
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
