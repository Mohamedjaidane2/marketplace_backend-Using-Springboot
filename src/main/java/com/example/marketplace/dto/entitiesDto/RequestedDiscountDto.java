package com.example.marketplace.dto.entitiesDto;

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
public class RequestedDiscountDto {
    private int requestedDiscountId;

    private AccountDto account;

    private AdvertisementDto advertisement;

    private Float requestedAmount;

    private Date requestDate;

    public static List<RequestedDiscountDto> customListMapping(List<RequestedDiscount> discountRequests) {
        if(discountRequests ==null) return null;
        ArrayList<RequestedDiscountDto> requestedDiscountDtoArrayList = new ArrayList<>();
        for (RequestedDiscount requestedDiscount : discountRequests){
            RequestedDiscountDto requestedDiscountDto = customMapping(requestedDiscount);
            requestedDiscountDtoArrayList.add(requestedDiscountDto);
        }
        return requestedDiscountDtoArrayList;
    }

    @Override
    public String toString() {
        return "RequestedDiscountDto{" +
                "requestedDiscountId=" + requestedDiscountId +
                ", account=" + account +
                ", advertisement=" + advertisement +
                ", requestedAmount=" + requestedAmount +
                ", requestDate=" + requestDate +
                '}';
    }
    public static RequestedDiscountDto customMapping (RequestedDiscount requestedDiscount){
        return RequestedDiscountDto.builder()
                .requestedDiscountId(requestedDiscount.getRequestedDiscountId())
                .requestedAmount(requestedDiscount.getRequestedAmount())
                .advertisement(AdvertisementDto.customMapping(requestedDiscount.getAdvertisement()))
                .account(AccountDto.customMapping(requestedDiscount.getAccount()))
                .requestDate(requestedDiscount.getRequestDate())
                .build();
    }
}
