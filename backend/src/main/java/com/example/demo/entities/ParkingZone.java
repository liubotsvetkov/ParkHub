package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ParkingZone", uniqueConstraints=
        @UniqueConstraint(columnNames={"neighborhoodId", "zoneIdent"})
)
public class ParkingZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, length=255)
    private String zoneIdent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="neighborhoodId")
    private Neighborhood neighborhood;
    @OneToMany(mappedBy="parkingZone", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ParkingSlot> parkingSlots;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingZone that = (ParkingZone) o;
        return zoneIdent.equals(that.zoneIdent);
    }

    public ParkingZone(String zoneIdent, Neighborhood neighborhood, List<ParkingSlot> parkingSlots) {
        this.zoneIdent = zoneIdent;
        this.neighborhood = neighborhood;
        this.parkingSlots = parkingSlots;
    }
}
