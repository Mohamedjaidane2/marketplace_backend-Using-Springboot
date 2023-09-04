package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.AdvertisementDto;
import com.example.marketplace.dto.entitiesDto.HistoryDto;
import com.example.marketplace.dto.entitiesDto.OrderDto;

import java.util.List;

public interface IOrderServices {
    SuccessDto toOrder(OrderDto orderDto);

    OrderDto getOrderById(String orderId);

    List<OrderDto> getOrderByAccount(AccountDto accountDto);

    SuccessDto cancelOrderById(String orderId);

    List<OrderDto> getAllOrders();
}
