package com.example.marketplace.controller;

import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestNewDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestUpdateCounterDto;
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

    @PostMapping("/send/{accountId}/{advertisementId}")
    @ApiOperation(value = "Send a discount request")
    public ResponseEntity<SuccessDto> sendDiscountRequest(@PathVariable Integer accountId,@PathVariable Integer advertisementId,@RequestBody DiscountRequestNewDto discountRequestNewDto) {
        return ResponseEntity.ok(discountRequestService.sendDiscount(accountId,advertisementId, discountRequestNewDto));
    }

    @PutMapping("/counter/{discountRequestId}")
    @ApiOperation(value = "Counter a discount request")
    public ResponseEntity<SuccessDto> counterDiscountRequest(@PathVariable Integer discountRequestId, @RequestBody DiscountRequestUpdateCounterDto discountRequestUpdateCounterDto) {
        return ResponseEntity.ok(discountRequestService.counterDiscount(discountRequestId, discountRequestUpdateCounterDto));
    }

    @PutMapping("/update/{discountRequestId}")
    @ApiOperation(value = "Update a discount request")
    public ResponseEntity<SuccessDto> updateDiscountRequest(@PathVariable Integer discountRequestId, @RequestBody DiscountRequestUpdateDto discountRequestUpdateDto) {
        return ResponseEntity.ok(discountRequestService.updateDiscount(discountRequestId, discountRequestUpdateDto));
    }

    @GetMapping("/{discountId}")
    @ApiOperation(value = "Get discount request by ID")
    public ResponseEntity<DiscountRequestDto> getDiscountRequestById(@PathVariable Integer discountId) {
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
    public ResponseEntity<SuccessDto> deleteDiscountRequestById(@PathVariable Integer discountId) {
        return ResponseEntity.ok(discountRequestService.deleteDiscountRequestById(discountId));
    }

    @GetMapping("/account/{accountId}")
    @ApiOperation(value = "Get discount requests by account ID")
    public ResponseEntity<List<DiscountRequestDto>> getDiscountsByAccountId(@PathVariable Integer accountId) {
        List<DiscountRequestDto> discountRequests = discountRequestService.getDiscountByAccountId(accountId);
        return ResponseEntity.ok(discountRequests);
    }

    @GetMapping("/advertisementOowner/{advertisementOwnerId}")
    @ApiOperation(value = "Get discount requests by advertisement owner ID")
    public ResponseEntity<List<DiscountRequestDto>> getDiscountsByAdvertisementOwnerId(@PathVariable Integer advertisementOwnerId) {
        List<DiscountRequestDto> discountRequests = discountRequestService.getDiscountByAdvertisementOwnerId(advertisementOwnerId);
        return ResponseEntity.ok(discountRequests);
    }
    @PutMapping("/accept/{discountId}")
    @ApiOperation(value = "Accept a discount request")
    public ResponseEntity<SuccessDto> acceptDiscount(@PathVariable Integer discountId) {
        return ResponseEntity.ok(discountRequestService.acceptDiscount(discountId));
    }

    @PutMapping("/decline/{discountId}")
    @ApiOperation(value = "Decline a discount request")
    public ResponseEntity<SuccessDto> declineDiscount(@PathVariable Integer discountId) {
        return ResponseEntity.ok(discountRequestService.declineDiscount(discountId));
    }
}
