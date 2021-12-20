package com.example.parkhub.parkingDataModule.data;

import com.example.parkhub.parkingDataModule.projections.CitySummary;
import com.example.parkhub.parkingDataModule.projections.NeighborhoodSummary;
import com.example.parkhub.parkingDataModule.projections.ParkingSlotSummary;

import java.util.Collection;
import java.util.Optional;

public interface ParkingData {

    Collection<ParkingSlotSummary> getAllParkingSlots();

    Collection<ParkingSlotSummary> getParkingSlotsByCity(int cityId);

    Collection<ParkingSlotSummary> getParkingSlotsByNeighborhood(int neighborhoodId);

    Optional<ParkingSlotSummary> getParkingSlot(int slotId);

    Collection<CitySummary> getAllCities();

    Collection<NeighborhoodSummary> getAllNeighborhoodsByCity(int cityId);
}
