package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.dto.AddressDtos.AddressNewDto;
import com.example.marketplace.dto.AddressDtos.AddressUpdateDtos;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/address")
@RequestMapping("/api/address")
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
    public ResponseEntity<SuccessDto> updateAddress(@RequestBody AddressUpdateDtos addressUpdateDto,Integer id) {
        return ResponseEntity.ok(iAddressService.updateAddress(addressUpdateDto,id));
    }

    @GetMapping("/{addressId}")
    @ApiOperation(value = "Get address by ID")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Integer addressId) {
        AddressDto addressDto = iAddressService.getAddressById(addressId);
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
    public ResponseEntity<SuccessDto> deleteAddressById(@PathVariable Integer addressId) {
        return ResponseEntity.ok(iAddressService.deleteAddressById(addressId));
    }
}
