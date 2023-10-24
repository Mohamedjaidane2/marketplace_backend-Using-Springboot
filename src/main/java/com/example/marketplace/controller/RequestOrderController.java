package com.example.marketplace.controller;

import com.example.marketplace.dto.RequestOrderDtos.RequestOrderDto;
import com.example.marketplace.dto.RequestOrderDtos.RequestOrderNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IRequestOrderServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/request-order")
@RequestMapping("/api/request-order")
@RestController
@RequiredArgsConstructor
public class RequestOrderController {
    private final IRequestOrderServices requestOrderService;

    @PostMapping("/send")
    @ApiOperation(value = "Send request order")
    public ResponseEntity<SuccessDto> sendRequestOrder(@RequestBody RequestOrderNewDto requestOrderNewDto) {
        return ResponseEntity.ok(requestOrderService.sendRequestOrder(requestOrderNewDto));
    }

    @GetMapping("/{orderId}")
    @ApiOperation(value = "Get request order by ID")
    public ResponseEntity<RequestOrderDto> getRequestOrderById(@PathVariable String orderId) {
        RequestOrderDto requestOrder = requestOrderService.getRequestOrderById(orderId);
        return ResponseEntity.ok(requestOrder);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all request orders")
    public ResponseEntity<List<RequestOrderDto>> getAllRequestOrders() {
        List<RequestOrderDto> requestOrders = requestOrderService.getAllRequestOrders();
        return ResponseEntity.ok(requestOrders);
    }

    @DeleteMapping("/delete/{orderId}")
    @ApiOperation(value = "Delete request order by ID")
    public ResponseEntity<SuccessDto> deleteRequestOrderById(@PathVariable String orderId) {
        return ResponseEntity.ok(requestOrderService.deleteRequestOrderById(orderId));
    }

    @PostMapping("/accept/{orderId}")
    @ApiOperation(value = "Accept request order")
    public ResponseEntity<SuccessDto> acceptOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(requestOrderService.acceptOrder(orderId));
    }

    @PostMapping("/decline/{orderId}")
    @ApiOperation(value = "Decline request order")
    public ResponseEntity<SuccessDto> declineOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(requestOrderService.declineOrder(orderId));
    }
}
