package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementNewDto;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementUpdateDtos;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IAdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/advertisement")
@RequestMapping("/api/advertisement")
@RestController
@RequiredArgsConstructor
public class AdvertisementController {
    private final IAdvertisementService advertisementService;

    @PostMapping("/post")
    @ApiOperation(value = "Post advertisement")
    public ResponseEntity<SuccessDto> postAdvertisement(@RequestBody AdvertisementNewDto advertisementNewDto) {
        return ResponseEntity.ok(advertisementService.postAdvertisement(advertisementNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update advertisement")
    public ResponseEntity<SuccessDto> updateAdvertisement(@RequestBody AdvertisementUpdateDtos advertisementUpdateDto) {
        return ResponseEntity.ok(advertisementService.updateAdvertisement(advertisementUpdateDto));
    }

    @GetMapping("/{advertisementId}")
    @ApiOperation(value = "Get advertisement by ID")
    public ResponseEntity<AdvertisementDto> getAdvertisementById(@PathVariable String advertisementId) {
        AdvertisementDto advertisementDto = advertisementService.getAdvertisementById(advertisementId);
        return ResponseEntity.ok(advertisementDto);
    }

    @GetMapping("/account")
    @ApiOperation(value = "Get advertisements by account")
    public ResponseEntity<List<AdvertisementDto>> getAdvertisementByAccount(@RequestBody AccountDto accountDto) {
        List<AdvertisementDto> advertisements = advertisementService.getAdvertisementByAccount(accountDto);
        return ResponseEntity.ok(advertisements);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all advertisements")
    public ResponseEntity<List<AdvertisementDto>> getAllAdvertisements() {
        List<AdvertisementDto> advertisements = advertisementService.getAllAdvertisement();
        return ResponseEntity.ok(advertisements);
    }

    @GetMapping("/feed")
    @ApiOperation(value = "Get my feed list")
    public ResponseEntity<List<AdvertisementDto>> getMyFeedList(@RequestBody AccountDto accountDto) {
        List<AdvertisementDto> advertisements = advertisementService.getMyFeedList(accountDto);
        return ResponseEntity.ok(advertisements);
    }

    @DeleteMapping("/delete/{advertisementId}")
    @ApiOperation(value = "Delete advertisement by ID")
    public ResponseEntity<SuccessDto> deleteAdvertisement(@PathVariable Integer advertisementId) {
        return ResponseEntity.ok(advertisementService.deleteAdvertisement(advertisementId));
    }

    @PostMapping("/acceptDiscount")
    @ApiOperation(value = "Accept discount request")
    public ResponseEntity<SuccessDto> acceptDiscount(@RequestBody DiscountRequestDto discountRequestDto) {
        return ResponseEntity.ok(advertisementService.acceptDiscount(discountRequestDto));
    }

    @PostMapping("/declineDiscount")
    @ApiOperation(value = "Decline discount request")
    public ResponseEntity<SuccessDto> declineDiscount(@RequestBody DiscountRequestDto discountRequestDto) {
        return ResponseEntity.ok(advertisementService.declineDiscount(discountRequestDto));
    }
}
