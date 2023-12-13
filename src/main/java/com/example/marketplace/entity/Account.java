package com.example.marketplace.entity;

import com.example.marketplace.Enum.ESellerLevel;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    private String ownerEmail;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Wallet wallet;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Information information;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Sales> sales;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<BankData> bankData;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Favorites> favorites;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<DiscountRequest> discountRequests;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    @Enumerated(EnumType.STRING)
    private ESellerLevel sellerLevel;

    private boolean isActivated ;
}