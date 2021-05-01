package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment", nullable = false)
    private int id;
    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private User user;

    @PrePersist
    protected void onCreate() {
        paymentDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        paymentDate = new Date();
    }
}
