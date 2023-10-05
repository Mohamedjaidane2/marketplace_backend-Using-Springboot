package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.dto.OrderDtos.OrderNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IOrderServices {
    SuccessDto toOrder(OrderNewDto orderNewDto);

    OrderDto getOrderById(String orderId);

    List<OrderDto> getOrderByAccount(AccountDto accountDto);

    SuccessDto cancelOrderById(String orderId);

    List<OrderDto> getAllOrders();
}
