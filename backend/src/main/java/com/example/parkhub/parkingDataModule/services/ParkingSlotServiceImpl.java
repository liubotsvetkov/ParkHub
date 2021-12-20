package com.example.parkhub.parkingDataModule.services;

import com.example.parkhub.parkingDataModule.data.ParkingData;
import com.example.parkhub.parkingDataModule.projections.ParkingSlotSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Autowired
    ParkingData parkingData;

    @Override
    public Collection<ParkingSlotSummary> getAllParkingSlots() {
        return parkingData.getAllParkingSlots();
    }

    @Override
    public Collection<ParkingSlotSummary> getParkingSlotsByCity(int cityId) {
        return parkingData.getParkingSlotsByCity(cityId);
    }

    @Override
    public Collection<ParkingSlotSummary> getParkingSlotsByNeighborhood(int neighborhoodId) {
        return parkingData.getParkingSlotsByNeighborhood(neighborhoodId);
    }

    @Override
    public Optional<ParkingSlotSummary> getParkingSlot(int slotId) {
        return parkingData.getParkingSlot(slotId);
    }

}


