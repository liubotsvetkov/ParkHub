package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParkingZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, unique=true)
    private String zoneIdent;
    @ManyToOne
    @JoinColumn(name="cityId", nullable=false)
    private City city;
    @OneToMany(mappedBy="parkingZone", cascade = CascadeType.ALL)
    private List<ParkingSlot> parkingSlots;
}
