package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.dto.AddressDtos.AddressNewDto;
import com.example.marketplace.dto.AddressDtos.AddressUpdateDtos;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    @Override
    public SuccessDto addAddress(AddressNewDto addressNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateAddress(AddressUpdateDtos addressUpdateDto) {
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
