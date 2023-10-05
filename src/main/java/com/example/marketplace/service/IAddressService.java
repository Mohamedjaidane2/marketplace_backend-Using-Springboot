package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.dto.AddressDtos.AddressNewDto;
import com.example.marketplace.dto.AddressDtos.AddressUpdateDtos;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IAddressService {
    SuccessDto addAddress(AddressNewDto addressNewDto);

    SuccessDto updateAddress(AddressUpdateDtos addressUpdateDto);


    AddressDto getAddressById(String addressId);

    AddressDto getAddressByAccount(AccountDto accountDto);

    List<AddressDto> getAllAddress();

    SuccessDto deleteAddressById(String addressId);

}
