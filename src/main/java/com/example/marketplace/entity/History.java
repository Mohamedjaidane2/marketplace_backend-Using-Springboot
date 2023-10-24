package com.example.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int history_id;

    @ManyToOne
    @JoinColumn(name = "advertisment_id", nullable = false)
    private Advertisement advertisment;

}