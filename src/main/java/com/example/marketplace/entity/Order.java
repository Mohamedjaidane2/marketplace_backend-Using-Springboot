package com.example.marketplace.entity;

import com.example.marketplace.Enum.EOrderStatus;
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
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date", updatable = false)
    private Date orderDate;


    private Float totalPrice;

    @Enumerated(EnumType.STRING)
    private EOrderStatus orderStatus;


    @ManyToOne
    @JoinColumn(name = "advertisement_id", nullable = false)
    private Advertisement advertisement;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}