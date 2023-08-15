package com.example.marketplace.entity;

import com.example.marketplace.Enum.EAdvertisementStatus;
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
    private Integer accound_id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

//  @OneToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "information_id")
//  private Information information;

//    @OneToMany(mappedBy="account")
//    private List<Sales> sales;

//    @OneToMany(mappedBy="account")
//    private List<RequestOrder> requestOrders;

//    @OneToMany(mappedBy="account")
//    private List<BankData> bankData;

    @OneToMany(mappedBy="account")
    private List<Order> orders;

//    @OneToMany(mappedBy="account")
//    private List<Favorites> favorites;

//    @OneToMany(mappedBy="account")
//    private List<DiscountRequest> discountRequest;

    @OneToMany(mappedBy="account")
    private List<Advertisement> advertisements;

//    @Enumerated(EnumType.STRING)
//    private ESellerLevel sellerLevel;

}