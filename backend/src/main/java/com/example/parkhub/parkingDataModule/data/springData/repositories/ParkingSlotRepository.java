package com.example.parkhub.parkingDataModule.data.springData.repositories;

import com.example.parkhub.parkingDataModule.data.springData.entities.ParkingSlot;
import com.example.parkhub.parkingDataModule.projections.ParkingSlotSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {

    Collection<ParkingSlotSummary> findAllProjectedBy();

    Collection<ParkingSlotSummary> findByNeighborhoodCityId(int cityId);

    Collection<ParkingSlotSummary> findByNeighborhoodId(int neighborhoodId);

    Optional<ParkingSlotSummary> findById(int slotId);

    Optional<ParkingSlot> findByLatitudeAndLongitude(double latitude, double longitude);

}
