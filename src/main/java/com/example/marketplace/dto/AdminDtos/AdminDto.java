package com.example.marketplace.dto.AdminDtos;
import com.example.marketplace.Enum.ERole;
import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdminDto {

    private String adminName;

    private ERole Role;

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminName='" + adminName + '\'' +
                ", Role=" + Role +
                '}';
    }

    public static AdminDto customMapping(Admin admin){
        return AdminDto.builder()
                .adminName(admin.getAdminName())
                .Role(admin.getRole())
                .build();
    }
}
