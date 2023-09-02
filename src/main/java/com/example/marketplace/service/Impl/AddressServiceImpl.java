package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.AddressDto;
import com.example.marketplace.service.IAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    @Override
    public SuccessDto addAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public SuccessDto updateAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public AddressDto getAddressById(String addressId) {
        return null;
    }

    @Override
    public AddressDto getAddressByAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public List<AddressDto> getAllAddress() {
        return null;
    }

    @Override
    public SuccessDto deleteAddressById(String addressId) {
        return null;
    }
}
