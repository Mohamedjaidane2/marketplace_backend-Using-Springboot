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
@Table(name = "request_order")
public class RequestOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int requestOrderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "request_date", updatable = false)
    private Date requestDate;
}
