package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.RequestOrderDtos.RequestOrderDto;
import com.example.marketplace.dto.RequestOrderDtos.RequestOrderNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IRequestOrderServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestOrderServiceImpl implements IRequestOrderServices {
    @Override
    public SuccessDto sendRequestOrder(RequestOrderNewDto requestOrderNewDto) {
        return null;
    }

    @Override
    public RequestOrderDto getRequestOrderById(String orderId) {
        return null;
    }

    @Override
    public List<RequestOrderDto> getAllRequestOrders() {
        return null;
    }

    @Override
    public SuccessDto deleteRequestOrderById(String orderId) {
        return null;
    }

    @Override
    public SuccessDto acceptOrder(String orderId) {
        return null;
    }

    @Override
    public SuccessDto declineOrder(String orderId) {
        return null;
    }
}
