package com.example.marketplace.dto.AdvertisementDtos;
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

    private int accountId;

    private int productId;

    private EAdvertisementStats advertisementStats;

    private EAdvertisementSoldStats advertisementSoldStats;

    private int orderId;

    private Double price;

    private Double oldPrice;

    private Date creationDate;

    @Override
    public String toString() {
        return "AdveertisementDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", advertisementStats=" + advertisementStats +
                ", advertisementSoldStats=" + advertisementSoldStats +
                ", productId=" + productId +
                ", sellerId=" + accountId +
                ", orderId=" + orderId +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", creationDate=" + creationDate +
                '}';
    }

    public static AdvertisementDto customMapping(Advertisement advertisement) {
        AdvertisementDtoBuilder builder = AdvertisementDto.builder()
                .creationDate(advertisement.getCreationDate())
                .id(advertisement.getId())
                .title(advertisement.getTitle())
                .description(advertisement.getDescription())
                .accountId(advertisement.getAccount().getAccountId())
                .productId(advertisement.getProduct().getId())
                .advertisementStats(advertisement.getAdvertisementStats())
                .advertisementSoldStats(advertisement.getAdvertisementSoldStats())
                .price(advertisement.getPrice());

        Order order = advertisement.getOrder();
        if (order != null) {
            builder.orderId(order.getOrderId());
        }

        return builder.build();
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
