package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.dto.AddressDtos.AddressNewDto;
import com.example.marketplace.dto.AddressDtos.AddressUpdateDtos;
import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.Address;
import com.example.marketplace.entity.Information;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.repository.IAddressRepository;
import com.example.marketplace.repository.IInformationRepository;
import com.example.marketplace.service.IAddressService;
import com.example.marketplace.service.IInformationServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
    private final IAddressRepository iAddressRepository;
    private final IInformationRepository iInformationRepository;
    private final ModelMapper modelMapper;


    @Override
    public SuccessDto addAddress(AddressNewDto addressNewDto) {

        Information information = iInformationRepository.findById(addressNewDto.getInformation_id())
                .orElseThrow(() -> new EntityNotFoundException("Information not found", ErrorCodes.INFORMATION_NOT_FOUND));


        Address address= Address.builder()
                .addressName(addressNewDto.getAddressName())
                .additionalAddress(addressNewDto.getAdditionalAddress())
                .city(addressNewDto.getCity())
                .postalCode(addressNewDto.getPostalCode())
                .information(information)
                .build();
        iAddressRepository.save(address);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateAddress(AddressUpdateDtos addressUpdateDto,Integer id) {
        Address address = iAddressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("address not found", ErrorCodes.ADDRESS_NOT_FOUND));

        modelMapper.map(addressUpdateDto, address);
        iAddressRepository.save(address);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public AddressDto getAddressById(Integer addressId) {
        Optional<Address> address = iAddressRepository.findById(addressId);
        if (address.isEmpty()) {
            throw new EntityNotFoundException("Address not found", ErrorCodes.INFORMATION_NOT_FOUND);
        }
        return AddressDto.customMapping(address.get());
    }

    @Override
    public List<AddressDto> getAllAddress() {
        return iAddressRepository.findAll()
                .stream()
                .map(AddressDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteAddressById(Integer addressId) {
        Optional<Address> address = iAddressRepository.findById(addressId);
        if(address.isEmpty())
            throw new EntityNotFoundException("address not found!",ErrorCodes.INFORMATION_NOT_FOUND);
        iAddressRepository.delete(address.get());
        return SuccessDto
                .builder()
                .message(SuccessMessage.SUCCESSFULLY_DELETED)
                .build();
    }
}
