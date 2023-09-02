package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AddressDto;
import com.example.marketplace.entity.Address;

import java.util.List;

public interface IAddressService {
    SuccessDto addAddress(AddressDto addressDto);

    SuccessDto updateAddress(AddressUpdateDto addressUpdateDto);


    AddressDto getAddressById(String addressId);

    List<Address> getAllAddress();

    SuccessDto deleteAddressById(String addressId);

}
