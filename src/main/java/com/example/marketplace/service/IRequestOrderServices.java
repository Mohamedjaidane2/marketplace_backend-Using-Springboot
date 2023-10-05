package com.example.marketplace.service;

import com.example.marketplace.dto.RequestOrderDtos.RequestOrderDto;
import com.example.marketplace.dto.RequestOrderDtos.RequestOrderNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;


public interface IRequestOrderServices {

    SuccessDto sendRequestOrder(RequestOrderNewDto requestOrderNewDto);
    RequestOrderDto getRequestOrderById(String orderId);

    List<RequestOrderDto> getAllRequestOrders();

    SuccessDto deleteRequestOrderById(String orderId);

    SuccessDto acceptOrder(String orderId);
    SuccessDto declineOrder(String orderId);
}