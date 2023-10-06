package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.dto.OrderDtos.OrderNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IOrderServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/order")
@RequestMapping("/api/order")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final IOrderServices orderService;

    @PostMapping("/create")
    @ApiOperation(value = "Create order")
    public ResponseEntity<SuccessDto> createOrder(@RequestBody OrderNewDto orderNewDto) {
        return ResponseEntity.ok(orderService.toOrder(orderNewDto));
    }

    @GetMapping("/{orderId}")
    @ApiOperation(value = "Get order by ID")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/account")
    @ApiOperation(value = "Get orders by account")
    public ResponseEntity<List<OrderDto>> getOrdersByAccount(@RequestBody AccountDto accountDto) {
        List<OrderDto> orders = orderService.getOrderByAccount(accountDto);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/cancel/{orderId}")
    @ApiOperation(value = "Cancel order by ID")
    public ResponseEntity<SuccessDto> cancelOrderById(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.cancelOrderById(orderId));
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
