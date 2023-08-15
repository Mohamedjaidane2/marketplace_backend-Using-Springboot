package com.example.marketplace.entity;

import com.example.marketplace.Enum.EFeedBack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.List;


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

//    @ManyToOne
//    @JoinColumn(name = "advertisment_id", nullable = false)
//    private Advertisment advertisment;
    @ManyToOne
    @JoinColumn(name = "advertisment_id", nullable = false)
    private Advertisement advertisment;

}