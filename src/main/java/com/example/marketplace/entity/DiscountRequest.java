package com.example.marketplace.entity;

import com.example.marketplace.Enum.EDiscountRequestStats;
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
@Table(name = "requested_discount")
public class DiscountRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestedDiscountId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;

    private double requestedAmount;
    private EDiscountRequestStats eDiscountRequestStats;

    private double counterDiscountAmount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date requestDate;

}
