package com.example.marketplace.dto.OrderDtos;

import com.example.marketplace.Enum.EOrderStatus;
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
public class OrderDto {
    private Integer orderId;

    private Date orderDate;

    private Float totalPrice;

    private EOrderStatus orderStatus;

    private AdvertisementDto advertisement;

    private AccountDto account;

    public static List<OrderDto> customListMapping(List<Order> orders) {
        if(orders==null) return null;
        ArrayList<OrderDto> orderDtoArrayList = new ArrayList<>();
        for (Order order : orders){
            OrderDto orderDto = customMapping(order);
            orderDtoArrayList.add(orderDto);
        }
        return orderDtoArrayList;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", advertisement=" + advertisement +
                ", account=" + account +
                '}';
    }
    public static OrderDto customMapping (Order order){
        return OrderDto.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .totalPrice(order.getTotalPrice())
                .orderStatus(order.getOrderStatus())
                .advertisement(AdvertisementDto.customMapping(order.getAdvertisement()))
                .account(AccountDto.customMapping(order.getAccount()))
                .build();
    }
}
