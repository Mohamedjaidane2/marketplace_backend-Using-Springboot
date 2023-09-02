package com.example.marketplace.dto.entitiesDto;

import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddressDto {

    private int AddressId;

    private String addressName;

    private String additionalAddress;

    private String city;


    private int postalCode;

    private InformationDto information;

    public static List<AddressDto> customListMapping(List<Address> addresses) {
        if(addresses==null) return null;
        ArrayList<AddressDto> addressDtoArrayList = new ArrayList<>();
        for (Address address : addresses){
            AddressDto addressDto = customMapping(address);
            addressDtoArrayList.add(addressDto);
        }
        return addressDtoArrayList;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "AddressId=" + AddressId +
                ", addressName='" + addressName + '\'' +
                ", additionalAddress='" + additionalAddress + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", information=" + information +
                '}';
    }
    public static AddressDto customMapping(Address address){
        return AddressDto.builder()
                .AddressId(address.getAddressId())
                .additionalAddress(address.getAdditionalAddress())
                .addressName(address.getAddressName())
                .information(InformationDto.customMapping(address.getInformation()))
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .build();
    }
}
