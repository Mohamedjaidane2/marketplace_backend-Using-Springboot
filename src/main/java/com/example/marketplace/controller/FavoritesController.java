package com.example.marketplace.controller;

import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.FavoritesDtos.FavoritesDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.repository.IFavoritesRepository;
import com.example.marketplace.service.IFavoritesServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/favorites")
@RequestMapping("/api/favorites")
@RestController
@RequiredArgsConstructor
public class FavoritesController {
    private final IFavoritesServices favoritesService;

    @PostMapping("/add/{advertisementId}/{accountId}")
    @ApiOperation(value = "Add an advertisement to favorites")
    public ResponseEntity<SuccessDto> addToFavorites(@PathVariable Integer advertisementId,@PathVariable Integer accountId) {
        return ResponseEntity.ok(favoritesService.addToFavorites(advertisementId,accountId));
    }

    @DeleteMapping("/remove/{favoriteId}")
    @ApiOperation(value = "Remove an advertisement from favorites")
    public ResponseEntity<SuccessDto> removeFromFavorites(@PathVariable Integer favoriteId ) {
        return ResponseEntity.ok(favoritesService.removeFromFavorites(favoriteId));
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all favorites")
    public ResponseEntity<List<FavoritesDto>> getAll() {
        List<FavoritesDto> favorites = favoritesService.getAllFavorites();
        return ResponseEntity.ok(favorites);
    }

    @GetMapping("/byAccount/{accountId}")
    @ApiOperation(value = "Get favorites by account ID")
    public ResponseEntity<List<FavoritesDto>> getFavoritesByAccountId(@PathVariable Integer accountId) {
        List<FavoritesDto> favorites = favoritesService.getFavoritesByAccountId(accountId);
        return ResponseEntity.ok(favorites);
    }

}
