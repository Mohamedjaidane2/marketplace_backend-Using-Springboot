package com.example.marketplace.dto.DiscountRequestDtos;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
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
public class DiscountRequestDto {
    private int requestedDiscountId;

    private AccountDto account;

    private AdvertisementDto advertisement;

    private Float requestedAmount;

    private Date requestDate;

    public static List<DiscountRequestDto> customListMapping(List<DiscountRequest> discountRequests) {
        if(discountRequests ==null) return null;
        ArrayList<DiscountRequestDto> discountRequestDtoArrayList = new ArrayList<>();
        for (DiscountRequest discountRequest : discountRequests){
            DiscountRequestDto discountRequestDto = customMapping(discountRequest);
            discountRequestDtoArrayList.add(discountRequestDto);
        }
        return discountRequestDtoArrayList;
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
    public static DiscountRequestDto customMapping (DiscountRequest discountRequest){
        return DiscountRequestDto.builder()
                .requestedDiscountId(discountRequest.getRequestedDiscountId())
                .requestedAmount(discountRequest.getRequestedAmount())
                .advertisement(AdvertisementDto.customMapping(discountRequest.getAdvertisement()))
                .account(AccountDto.customMapping(discountRequest.getAccount()))
                .requestDate(discountRequest.getRequestDate())
                .build();
    }
}
