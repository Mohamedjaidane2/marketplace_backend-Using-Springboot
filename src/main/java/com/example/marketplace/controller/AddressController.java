package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.dto.AddressDtos.AddressNewDto;
import com.example.marketplace.dto.AddressDtos.AddressUpdateDtos;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/address")
@RestController
@RequiredArgsConstructor
public class AddressController {
    private final IAddressService iAddressService;

    @PostMapping("/create")
    @ApiOperation(value = "Create address")
    public ResponseEntity<SuccessDto> addAddress(@RequestBody AddressNewDto addressNewDto) {
        return ResponseEntity.ok(iAddressService.addAddress(addressNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update address")
    public ResponseEntity<SuccessDto> updateAddress(@RequestBody AddressUpdateDtos addressUpdateDto) {
        return ResponseEntity.ok(iAddressService.updateAddress(addressUpdateDto));
    }

    @GetMapping("/{addressId}")
    @ApiOperation(value = "Get address by ID")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable String addressId) {
        AddressDto addressDto = iAddressService.getAddressById(addressId);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/account")
    @ApiOperation(value = "Get address by account")
    public ResponseEntity<AddressDto> getAddressByAccount(@RequestBody AccountDto accountDto) {
        AddressDto addressDto = iAddressService.getAddressByAccount(accountDto);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all addresses")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addresses = iAddressService.getAllAddress();
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("/delete/{addressId}")
    @ApiOperation(value = "Delete address by ID")
    public ResponseEntity<SuccessDto> deleteAddressById(@PathVariable String addressId) {
        return ResponseEntity.ok(iAddressService.deleteAddressById(addressId));
    }
}
