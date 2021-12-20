package com.example.parkhub.parkingDataModule.services;

import com.example.parkhub.parkingDataModule.projections.ParkingSlotSummary;

import java.util.Collection;
import java.util.Optional;

public interface ParkingSlotService {

    Collection<ParkingSlotSummary> getAllParkingSlots();

    Collection<ParkingSlotSummary> getParkingSlotsByCity(int cityId);

    Collection<ParkingSlotSummary> getParkingSlotsByNeighborhood(int neighborhoodId);

    Optional<ParkingSlotSummary> getParkingSlot(int slotId);

}
