package com.example.marketplace.dto.InformationDtos;

import com.example.marketplace.Enum.EComnsumerType;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class InformationUpdateDto {

    private String profilePicture;

    private String firstName;

    private String lastName;

    private String bio;

    private String phoneNumber;

    private EComnsumerType consumerType;
}
