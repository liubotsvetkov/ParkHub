package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="parking_zone", uniqueConstraints=
        @UniqueConstraint(columnNames={"id_neighborhood", "zone_ident"})
)
public class ParkingZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parking_zone", nullable = false)
    private int id;
    @Column(name = "zone_ident", nullable = false, length = 255)
    private String zoneIdent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id_neighborhood")
    private Neighborhood neighborhood;
    @OneToMany(mappedBy = "parkingZone", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
