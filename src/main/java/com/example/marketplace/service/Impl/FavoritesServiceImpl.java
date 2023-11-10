package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.FavoritesDtos.FavoritesDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Advertisement;
import com.example.marketplace.entity.Favorites;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IAdvertisementRepository;
import com.example.marketplace.repository.IFavoritesRepository;
import com.example.marketplace.service.IFavoritesServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@Service
@RequiredArgsConstructor
public class FavoritesServiceImpl implements IFavoritesServices {
    private final IAccountRepository accountRepository;
    private final IAdvertisementRepository advertisementRepository;
    private final IFavoritesRepository favoritesRepository;


    @Override
    public SuccessDto addToFavorites(Integer advertisementId, Integer accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Optional<Advertisement> advertisementOptional = advertisementRepository.findById(advertisementId);

        if (accountOptional.isEmpty()) {
            throw new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND);
        }

        if (advertisementOptional.isEmpty()) {
            throw new EntityNotFoundException("Advertisement not found", ErrorCodes.ADVERTISEMENT_NOT_FOUND);
        }

        Account account = accountOptional.get();
        Advertisement advertisement = advertisementOptional.get();
        List<Favorites> favorites = account.getFavorites();

        // Check if the advertisement is already in the favorites
        if (favorites.stream().anyMatch(fav -> fav.getAdvertisement().getId().equals(advertisementId))) {
            throw new InvalidOperationException("Advertisement already in favorites", ErrorCodes.ADVERTISEMENT_ALREADY_IN_FAVORITES);
        }



        // Create a new Favorites entity using the builder pattern
        Favorites newFavorite = Favorites.builder()
                .account(account)
                .advertisement(advertisement)
                .build();

        // Add the newFavorite to the favorites list
        favorites.add(newFavorite);

        accountRepository.save(account);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_ADDED)
                .build();
    }


    @Override
    public SuccessDto removeFromFavorites(Integer favoriteId) {
        Optional<Favorites> favoriteOptional = favoritesRepository.findById(favoriteId);
        if(favoriteOptional.isEmpty()){
            throw new InvalidOperationException("Favorite not found in favorites", ErrorCodes.FAVORITE_NOT_IN_FAVORITES);
        }
        favoritesRepository.delete(favoriteOptional.get());

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_REMOVED)
                .build();
    }
    @Override
    public List<FavoritesDto> getAllFavorites() {
        return favoritesRepository.findAll()
                .stream()
                .map(FavoritesDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public List<FavoritesDto> getFavoritesByAccountId(Integer accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);

        if (accountOptional.isEmpty()) {
            throw new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND);
        }

        Account account = accountOptional.get();

        return account.getFavorites().stream()
                .map(FavoritesDto::customMapping)
                .collect(Collectors.toList());
    }
}
