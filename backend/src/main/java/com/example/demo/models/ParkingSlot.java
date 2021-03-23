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
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, unique=true)
    private String slotIdent;
    private Date dateTimeUpdated;
    private int state;
    private double latitude;
    private double longitude;
    @ManyToOne
    @JoinColumn(name="parkingZoneId", nullable=false)
    private ParkingZone parkingZone;

    @PrePersist
    protected void onCreate() {
        dateTimeUpdated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateTimeUpdated = new Date();
    }
}
