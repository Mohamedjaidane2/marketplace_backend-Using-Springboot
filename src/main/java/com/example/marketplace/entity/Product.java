package com.example.marketplace.entity;

import com.example.marketplace.Enum.EColor;
import com.example.marketplace.Enum.EGender;
import com.example.marketplace.Enum.EProductStatus;
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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;


    @ElementCollection
    private List<String> images;

    @Enumerated(EnumType.STRING)
    private EProductStatus ProductStatus;

    @Enumerated(EnumType.STRING)
    private EColor color;

    private String features;

    @Enumerated(EnumType.STRING)
    private EGender eGender;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;
}
