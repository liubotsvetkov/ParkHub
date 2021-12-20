package com.example.parkhub.parkingDataModule.data;

import com.example.parkhub.parkingDataModule.data.springData.repositories.CityRepository;
import com.example.parkhub.parkingDataModule.data.springData.repositories.NeighborhoodRepository;
import com.example.parkhub.parkingDataModule.data.springData.repositories.ParkingSlotRepository;
import com.example.parkhub.parkingDataModule.projections.CitySummary;
import com.example.parkhub.parkingDataModule.projections.NeighborhoodSummary;
import com.example.parkhub.parkingDataModule.projections.ParkingSlotSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ParkingDataDBImpl implements ParkingData {

    @Autowired
    ParkingSlotRepository parkingSlotRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    NeighborhoodRepository neighborhoodRepository;

    @Override
    public Collection<ParkingSlotSummary> getAllParkingSlots() {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotRepository.findAllProjectedBy();
        return parkingSlots;
    }

    @Override
    public Collection<ParkingSlotSummary> getParkingSlotsByCity(int cityId) {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotRepository.findByNeighborhoodCityId(cityId);
        return parkingSlots;
    }

    @Override
    public Collection<ParkingSlotSummary> getParkingSlotsByNeighborhood(int neighborhoodId) {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotRepository.findByNeighborhoodId(neighborhoodId);
        return parkingSlots;
    }

    @Override
    public Optional<ParkingSlotSummary> getParkingSlot(int slotId) {
        Optional<ParkingSlotSummary> parkingSlots = parkingSlotRepository.findById(slotId);
        return parkingSlots;
    }

    @Override
    public Collection<CitySummary> getAllCities() {
        Collection<CitySummary> cities = cityRepository.findAllProjectedBy();
        return cities;
    }

    @Override
    public Collection<NeighborhoodSummary> getAllNeighborhoodsByCity(int cityId) {
        Collection<NeighborhoodSummary> neighborhoods = neighborhoodRepository.findByCityId(cityId);
        return neighborhoods;
    }
}
