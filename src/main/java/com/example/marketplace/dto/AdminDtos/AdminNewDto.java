package com.example.marketplace.dto.AdminDtos;

import com.example.marketplace.Enum.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdminNewDto {

    private String adminName;

    private ERole Role;

}
