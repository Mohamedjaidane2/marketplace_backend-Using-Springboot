package com.example.marketplace.dto.FavoritesDtos;
import com.example.marketplace.entity.Favorites;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FavoritesDto {

    private Integer favoritesId;

    private Integer accountId;

    private Integer advertisementId;

    @Override
    public String toString() {
        return "FavoritesDto{" +
                "favoritesId=" + favoritesId +
                ", account=" + accountId +
                ", advertisement=" + advertisementId +
                '}';
    }
    public static FavoritesDto customMapping (Favorites favorites){
        return FavoritesDto.builder()
                .favoritesId(favorites.getFavoritesId())
                .accountId(favorites.getAccount().getAccountId())
                .advertisementId(favorites.getAdvertisement().getId())
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
