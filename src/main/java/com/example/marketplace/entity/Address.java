package com.example.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AddressId;

    private String addressName;

    private String additionalAddress;

    private String city;

    private int postalCode;

    @ManyToOne
    @JoinColumn(name = "information_id",nullable = true)
    private Information information;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;
}
