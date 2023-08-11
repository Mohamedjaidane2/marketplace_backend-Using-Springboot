package com.example.marketplace.entity;
import com.example.marketplace.Enum.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "admin")
public class Admin extends User {

    private String adminName;

    @Enumerated(EnumType.STRING)
    private ERole Role;

}
