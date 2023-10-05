package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.dto.OrderDtos.OrderNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IOrderServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderServices {
    @Override
    public SuccessDto toOrder(OrderNewDto orderNewDto) {
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
