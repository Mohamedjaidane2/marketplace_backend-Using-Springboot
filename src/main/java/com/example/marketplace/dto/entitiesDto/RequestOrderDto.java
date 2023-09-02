package com.example.marketplace.dto.entitiesDto;

import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RequestOrderDto {

    private int requestOrderId;

    private AccountDto account;

    private AdvertisementDto advertisement;

    private Date requestDate;

    public static List<RequestOrderDto> customListMapping(List<RequestOrder> requestOrders) {
        if(requestOrders==null) return null;
        ArrayList<RequestOrderDto> requestOrderDtoArrayList = new ArrayList<>();
        for (RequestOrder requestOrder : requestOrders){
            RequestOrderDto requestOrderDto = customMapping(requestOrder);
            requestOrderDtoArrayList.add(requestOrderDto);
        }
        return requestOrderDtoArrayList;
    }

    @Override
    public String toString() {
        return "RequestOrderDto{" +
                "requestOrderId=" + requestOrderId +
                ", account=" + account +
                ", advertisement=" + advertisement +
                ", requestDate=" + requestDate +
                '}';
    }

    public static RequestOrderDto customMapping (RequestOrder order){
        return RequestOrderDto.builder()
                .requestOrderId(order.getRequestOrderId())
                .account(AccountDto.customMapping(order.getAccount()))
                .requestDate(order.getRequestDate())
                .advertisement(AdvertisementDto.customMapping(order.getAdvertisement()))
                .build();
    }
}
