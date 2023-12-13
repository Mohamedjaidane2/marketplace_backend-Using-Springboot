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

    @PostMapping("/create/{accountId}/{advertisementId}")
    @ApiOperation(value = "Create order")
    public ResponseEntity<SuccessDto> createOrder(@PathVariable Integer accountId, @PathVariable Integer advertisementId) {
        return ResponseEntity.ok(orderService.toOrder(accountId,advertisementId));
    }

    @GetMapping("/{orderId}")
    @ApiOperation(value = "Get order by ID")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Integer orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/account/{accountId}")
    @ApiOperation(value = "Get orders by account")
    public ResponseEntity<List<OrderDto>> getOrdersByAccount(@PathVariable Integer accountId) {
        List<OrderDto> orders = orderService.getOrderByAccount(accountId);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/cancel/{orderId}")
    @ApiOperation(value = "Cancel order by ID")
    public ResponseEntity<SuccessDto> cancelOrderById(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.cancelOrderById(orderId));
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/all/{accountId}")
    @ApiOperation(value = "Get all orders by account")
    public ResponseEntity<List<OrderDto>> getAllOrdersByOwner(@PathVariable Integer accountId) {
        List<OrderDto> orders = orderService.getAllOrdersByOwner(accountId);
        return ResponseEntity.ok(orders);
    }
}
