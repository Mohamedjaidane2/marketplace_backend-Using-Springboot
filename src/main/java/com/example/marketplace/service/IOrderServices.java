package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.dto.OrderDtos.OrderNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IOrderServices {
    SuccessDto toOrder(Integer accountId,Integer advertisementId);

    OrderDto getOrderById(Integer orderId);

    List<OrderDto> getOrderByAccount(Integer accountId);

    SuccessDto cancelOrderById(Integer orderId);

    List<OrderDto> getAllOrders();
}
