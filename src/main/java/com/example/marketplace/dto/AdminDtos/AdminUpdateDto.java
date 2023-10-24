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
public class AdminUpdateDto {

    private String adminName;

    private ERole Role;

}
