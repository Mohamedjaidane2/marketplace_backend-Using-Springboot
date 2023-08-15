package com.example.marketplace.entity;

import com.example.marketplace.Enum.ESellerLevel;
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
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "information_id")
    private Information information;

    @OneToMany(mappedBy = "account")
    private List<Sales> sales;


    @OneToMany(mappedBy="account")
    private List<BankData> bankData;

    @OneToMany(mappedBy="account")
    private List<Order> orders;

    @OneToMany(mappedBy = "account")
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "advertisement", fetch = FetchType.LAZY)
    private List<RequestedDiscount> discountRequests;

    @OneToMany(mappedBy="account")
    private List<Advertisement> advertisements;

    @OneToMany(mappedBy = "account")
    private List<RequestOrder> requestOrders;

    @Enumerated(EnumType.STRING)
    private ESellerLevel sellerLevel;

}