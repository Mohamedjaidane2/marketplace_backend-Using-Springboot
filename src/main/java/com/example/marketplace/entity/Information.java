package com.example.marketplace.entity;

import com.example.marketplace.Enum.EComnsumerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer information_id;

    private String profilePicture;

    private String FirstName;

    private String LastName;

    private String bio;

    private String phoneNumber;

    @OneToMany(mappedBy="information")
    private List<Address> addresses;


    @Enumerated(EnumType.STRING)
    @Column(name = "advertisement_status")
    private EComnsumerType comnsumerType;

}
