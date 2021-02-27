package com.example.demo.models;

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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date paymentDate;
    private String username;

    @PrePersist
    protected void onCreate() {
        paymentDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        paymentDate = new Date();
    }
}
