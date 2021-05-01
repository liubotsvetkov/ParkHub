package com.example.demo.repositories;

import com.example.demo.entities.ParkingSlot;
import com.example.demo.projections.ParkingSlotSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {
    Collection<ParkingSlotSummary> findAllProjectedBy();

    Collection<ParkingSlotSummary> findByParkingZoneNeighborhoodCityName(String cityName);

    Optional<ParkingSlot> findByLatitudeAndLongitude(double latitude, double longitude);

    @Query("select ps from ParkingSlot ps join ps.parkingZone pz join pz.neighborhood nb join nb.city c " +
            "where nb.name=?1 and c.name=?2")
    Collection<ParkingSlotSummary> getSlotByNeighCity(String neighName, String cityName);

    @Query("select ps from ParkingSlot ps join ps.parkingZone pz join pz.neighborhood nb join nb.city c " +
            "where pz.zoneIdent=?1 and nb.name=?2 and c.name=?3")
    Collection<ParkingSlotSummary> getSlotByZoneNeighCity(String zoneIdent, String neighName, String cityName);

    @Query("select ps from ParkingSlot ps join ps.parkingZone pz join pz.neighborhood nb join nb.city c " +
            "where ps.slotIdent=?1 and pz.zoneIdent=?2 and nb.name=?3 and c.name=?4")
    Optional<ParkingSlotSummary> getSlotBySlotZoneNeighCity(String slotIdent, String zoneIdent, String neighName, String cityName);
}
