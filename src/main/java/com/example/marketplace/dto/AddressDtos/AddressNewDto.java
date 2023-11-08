package com.example.marketplace.dto.AddressDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddressNewDto {

    private String addressName;

    private String additionalAddress;

    private String city;

    private int postalCode;

    private Integer information_id;

}
