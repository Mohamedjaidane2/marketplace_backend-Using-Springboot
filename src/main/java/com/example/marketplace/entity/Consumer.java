package com.example.marketplace.entity;
import com.example.marketplace.Enum.ERole;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "consumer")
public class Consumer extends User {

    private String pseudo;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;

    private String email;

    @OneToMany(mappedBy="consumer")
    private List<FeedBack> feedBacks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_id", nullable = false)
    private History history;
}
