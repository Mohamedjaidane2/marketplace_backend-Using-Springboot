package com.example.marketplace.controller;

import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IFavoritesServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("/favorites")
@RequestMapping("/api/favorites")
@RestController
@RequiredArgsConstructor
public class FavoritesController {
    private final IFavoritesServices favoritesService;

    @PostMapping("/add/{favoriteId}")
    @ApiOperation(value = "Add an advertisement to favorites")
    public ResponseEntity<SuccessDto> addToFavorites(@PathVariable Integer favoriteId, @RequestBody AdvertisementDto advertisementDto) {
        return ResponseEntity.ok(favoritesService.addToFavorites(favoriteId, advertisementDto));
    }

    @PostMapping("/remove/{favoriteId}")
    @ApiOperation(value = "Remove an advertisement from favorites")
    public ResponseEntity<SuccessDto> removeFromFavorites(@PathVariable Integer favoriteId, @RequestBody AdvertisementDto advertisementDto) {
        return ResponseEntity.ok(favoritesService.removeFromFavorites(favoriteId, advertisementDto));
    }
}
