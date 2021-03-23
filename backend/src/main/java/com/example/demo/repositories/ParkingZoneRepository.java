package com.example.demo.repositories;

import com.example.demo.entities.ParkingZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingZoneRepository extends JpaRepository<ParkingZone, Integer> {
    @Query("select pz from ParkingZone pz join pz.neighborhood nb join nb.city c where pz.zoneIdent=?1 and nb.name=?2 and c.name=?3")
    Optional<ParkingZone> getZoneByZoneNeighCity(String zoneIdent, String neighName, String cityName);
}
