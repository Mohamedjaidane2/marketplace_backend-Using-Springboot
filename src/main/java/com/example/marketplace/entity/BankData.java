package com.example.marketplace.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bankData")
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
