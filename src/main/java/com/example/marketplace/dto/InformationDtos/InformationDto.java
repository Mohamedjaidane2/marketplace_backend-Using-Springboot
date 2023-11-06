package com.example.marketplace.dto.InformationDtos;

import com.example.marketplace.Enum.EComnsumerType;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.entity.Information;
import com.example.marketplace.repository.IAddressRepository;
import com.example.marketplace.repository.IInformationRepository;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class InformationDto {

    private Integer information_id;

    private String profilePicture;

    private String firstName;

    private String lastName;

    private String bio;

    private String phoneNumber;

    private List<AddressDto> addresses;

    private EComnsumerType consumerType;

    @Override
    public String toString() {
        return "InformationDto{" +
                "information_id=" + information_id +
                ", profilePicture='" + profilePicture + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", bio='" + bio + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addresses=" + addresses +
                ", comnsumerType=" + consumerType +
                '}';
    }
    public static InformationDto customMapping(Information information) {
        InformationDto informationDto = InformationDto.builder()
                .information_id(information.getInformation_id())
                .profilePicture(information.getProfilePicture())
                .firstName(information.getFirstName())
                .lastName(information.getLastName())
                .bio(information.getBio())
                .phoneNumber(information.getPhoneNumber())
                .consumerType(information.getComnsumerType())
                .addresses(AddressDto.customListMapping(information.getAddresses()))
                .build();
        return informationDto;
    }
}
