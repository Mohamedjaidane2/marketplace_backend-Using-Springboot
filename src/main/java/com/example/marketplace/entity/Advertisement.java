package com.example.marketplace.entity;

import com.example.marketplace.Enum.EAdvertisementSoldStats;
import com.example.marketplace.Enum.EAdvertisementStats;
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
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private Account account;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private EAdvertisementStats advertisementStats;

    @Enumerated(EnumType.STRING)
    private EAdvertisementSoldStats advertisementSoldStats;

//    @OneToMany(mappedBy = "advertisement", fetch = FetchType.LAZY)
//    private List<RequestedDiscount> discountRequests;

    private Float price;
    @Column(name = "old_price")
    private Float oldPrice;

    @OneToMany(mappedBy = "advertisement", fetch = FetchType.LAZY)
    private List<RequestOrder> requestOrders;  // New relationship

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;
}
