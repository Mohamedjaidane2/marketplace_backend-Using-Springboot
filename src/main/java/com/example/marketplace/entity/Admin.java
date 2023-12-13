package com.example.marketplace.entity;
import com.example.marketplace.Enum.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "ADMIN")
@Table(name = "admin")
public class Admin extends User {

    private String adminName;

    @Enumerated(EnumType.STRING)
    private ERole Role;

}
