package com.example.demo.services;

import com.example.demo.projections.ParkingSlotSummary;
import com.example.demo.repositories.CityRepository;
import com.example.demo.repositories.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ParkingDataService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ParkingSlotRepository parkingSlotRepository;

    public Collection<ParkingSlotSummary> viewAllParkingSlots() {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotRepository.findAllProjectedBy();
        return parkingSlots;
    }

    public Collection<ParkingSlotSummary> viewParkingSlotsByCity(String cityName) {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotRepository.findByParkingZoneNeighborhoodCityName(cityName);
        return parkingSlots;
    }

    public Collection<ParkingSlotSummary> viewParkingSlotsByNeighAndCity(String neighName, String cityName) {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotRepository.getSlotByNeighCity(neighName, cityName);
        return parkingSlots;
    }

    public Collection<ParkingSlotSummary> viewParkingSlotsByZoneNeighAndCity(String zoneIdent, String neighName, String cityName) {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotRepository
                .getSlotByZoneNeighCity(zoneIdent, neighName, cityName);
        return parkingSlots;
    }

    public Optional<ParkingSlotSummary> viewParkingSlotsBySlotZoneNeighAndCity(String slotIdent, String zoneIdent,
                                                                               String neighName, String cityName) {
        Optional<ParkingSlotSummary> parkingSlots = parkingSlotRepository
                .getSlotBySlotZoneNeighCity(slotIdent, zoneIdent, neighName, cityName);
        return parkingSlots;
    }
}
