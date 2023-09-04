package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.OrderDto;
import com.example.marketplace.service.IOrderServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderServices {
    @Override
    public SuccessDto toOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto getOrderById(String orderId) {
        return null;
    }

    @Override
    public List<OrderDto> getOrderByAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public SuccessDto cancelOrderById(String orderId) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }
}
