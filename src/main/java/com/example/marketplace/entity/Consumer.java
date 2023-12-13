package com.example.marketplace.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "CONSUMER")
@Table(name = "consumer")
public class Consumer extends User {
    @Builder
    public Consumer(Integer id, String password, String email, String loginStatus, Date creationDate, List<Notification> notifications, Collection<Roles> roles, String pseudo, Account account ,History history) {
        super(id, password, email, loginStatus, creationDate, notifications, roles);
        this.pseudo = pseudo;
        this.account = account;
        this.history = history;
    }

    private String pseudo;

    @OneToMany(mappedBy="consumer")
    private List<FeedBack> feedBacks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_id", nullable = true)
    private History history;
}
