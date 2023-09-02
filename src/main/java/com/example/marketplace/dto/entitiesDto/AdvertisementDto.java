package com.example.marketplace.dto.entitiesDto;
import com.example.marketplace.Enum.EAdvertisementSoldStats;
import com.example.marketplace.Enum.EAdvertisementStats;
import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdvertisementDto {

    private Integer id;

    private String title;

    private String description;

    private AccountDto account;

    private ProductDto product;

    private EAdvertisementStats advertisementStats;

    private EAdvertisementSoldStats advertisementSoldStats;

    private List<OrderDto> orders;

    private Float price;

    private Float oldPrice;

    private List<RequestOrderDto> requestOrders;  // New relationship

    private Date creationDate;

    @Override
    public String toString() {
        return "AdveertisementDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", account=" + account +
                ", product=" + product +
                ", advertisementStats=" + advertisementStats +
                ", advertisementSoldStats=" + advertisementSoldStats +
                ", orders=" + orders +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", requestOrders=" + requestOrders +
                ", creationDate=" + creationDate +
                '}';
    }

    public static AdvertisementDto customMapping(Advertisement advertisement){
        return AdvertisementDto.builder()
                .creationDate(advertisement.getCreationDate())
                .id(advertisement.getId())
                .title(advertisement.getTitle())
                .description(advertisement.getDescription())
                .account(AccountDto.customMapping(advertisement.getAccount()))
                .product(ProductDto.customMapping(advertisement.getProduct()))
                .advertisementStats(advertisement.getAdvertisementStats())
                .advertisementSoldStats(advertisement.getAdvertisementSoldStats())
                .orders(OrderDto.customListMapping(advertisement.getOrders()))
                .price(advertisement.getPrice())
                .oldPrice(advertisement.getOldPrice())
                .requestOrders(RequestOrderDto.customListMapping(advertisement.getRequestOrders()))
                .build();
    }
    public static List<AdvertisementDto> customListMapping(List<Advertisement> advertisements){
        if (advertisements == null) return null;
        ArrayList<AdvertisementDto> advertisementDtoArrayList = new ArrayList<>();
        for (Advertisement advertisement : advertisements) {
            AdvertisementDto advertisementDto = customMapping(advertisement);
            advertisementDtoArrayList.add(advertisementDto);
        }
        return advertisementDtoArrayList;
    }
}
