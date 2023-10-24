package com.example.marketplace.controller;

import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestNewDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IDiscountRequestServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/discount-request")
@RequestMapping("/api/discount-request")
@RestController
@RequiredArgsConstructor
public class DiscountRequestController {
    private final IDiscountRequestServices discountRequestService;

    @PostMapping("/send")
    @ApiOperation(value = "Send a discount request")
    public ResponseEntity<SuccessDto> sendDiscountRequest(@RequestBody DiscountRequestNewDto discountRequestNewDto) {
        return ResponseEntity.ok(discountRequestService.sendDiscount(discountRequestNewDto));
    }

    @PostMapping("/counter")
    @ApiOperation(value = "Counter a discount request")
    public ResponseEntity<SuccessDto> counterDiscountRequest(@RequestBody DiscountRequestNewDto discountRequestNewDto) {
        return ResponseEntity.ok(discountRequestService.counterDiscount(discountRequestNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update a discount request")
    public ResponseEntity<SuccessDto> updateDiscountRequest(@RequestBody DiscountRequestUpdateDto discountRequestUpdateDto) {
        return ResponseEntity.ok(discountRequestService.updateDiscount(discountRequestUpdateDto));
    }

    @GetMapping("/{discountId}")
    @ApiOperation(value = "Get discount request by ID")
    public ResponseEntity<DiscountRequestDto> getDiscountRequestById(@PathVariable String discountId) {
        DiscountRequestDto discountRequestDto = discountRequestService.getDiscountById(discountId);
        return ResponseEntity.ok(discountRequestDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all discount requests")
    public ResponseEntity<List<DiscountRequestDto>> getAllDiscountRequests() {
        List<DiscountRequestDto> discountRequests = discountRequestService.getAllDiscount();
        return ResponseEntity.ok(discountRequests);
    }

    @DeleteMapping("/delete/{discountId}")
    @ApiOperation(value = "Delete a discount request by ID")
    public ResponseEntity<SuccessDto> deleteDiscountRequestById(@PathVariable String discountId) {
        return ResponseEntity.ok(discountRequestService.deleteDiscountRequestById(discountId));
    }
}
