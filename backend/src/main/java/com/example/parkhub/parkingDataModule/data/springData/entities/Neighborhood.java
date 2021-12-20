package com.example.parkhub.parkingDataModule.data.springData.entities;

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
@Table(name="neighborhood", uniqueConstraints=
        @UniqueConstraint(columnNames={"id_city", "name"})
)
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_neighborhood", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id_city")
    private City city;
    @OneToMany(mappedBy = "neighborhood", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ParkingSlot> parkingSlots;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighborhood neighborhood = (Neighborhood) o;
        return name.equals(neighborhood.name);
    }

    public Neighborhood(String name, City city, List<ParkingSlot> parkingSlots) {
        this.name = name;
        this.city = city;
        this.parkingSlots = parkingSlots;
    }


}
