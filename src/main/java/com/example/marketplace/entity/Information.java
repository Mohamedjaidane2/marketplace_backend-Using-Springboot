package com.example.marketplace.entity;

import com.example.marketplace.Enum.EComnsumerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer information_id;

    private String profilePicture;

    private String firstName;

    private String lastName;

    private String bio;

    private String phoneNumber;

    @OneToMany(mappedBy="information",fetch = FetchType.EAGER)
    private List<Address> addresses;

    @Enumerated(EnumType.STRING)
    @Column(name = "advertisement_status")
    private EComnsumerType comnsumerType;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;
}
