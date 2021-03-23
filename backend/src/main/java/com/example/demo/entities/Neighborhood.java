package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Neighborhood", uniqueConstraints=
        @UniqueConstraint(columnNames={"cityId", "name"})
)
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, length=255)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="cityId")
    private City city;
    @OneToMany(mappedBy="neighborhood", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ParkingZone> parkingZones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighborhood neighborhood = (Neighborhood) o;
        return name.equals(neighborhood.name);
    }

    public Neighborhood(String name, City city, List<ParkingZone> parkingZones) {
        this.name = name;
        this.city = city;
        this.parkingZones = parkingZones;
    }


}
