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
@Table(name = "advertisement")
public class BankData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bankData_id;

    private String bankName;
    private String rib;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

}
