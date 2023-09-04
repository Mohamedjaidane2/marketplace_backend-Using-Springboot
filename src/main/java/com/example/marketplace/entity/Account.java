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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "information_id")
    private Information information;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Sales> sales;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<BankData> bankData;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<DiscountRequest> discountRequests;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<RequestOrder> requestOrders;

    @Enumerated(EnumType.STRING)
    private ESellerLevel sellerLevel;
}