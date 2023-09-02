package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.AddressDto;
import com.example.marketplace.entity.Address;

import java.util.List;

public interface IAddressService {
    SuccessDto addAddress(AddressDto addressDto);

    SuccessDto updateAddress(AddressDto addressDto);


    AddressDto getAddressById(String addressId);

    AddressDto getAddressByAccount(AccountDto accountDto);

    List<AddressDto> getAllAddress();

    SuccessDto deleteAddressById(String addressId);

}
