package com.example.demo.services;

import com.example.demo.Beans.CityDto;
import com.example.demo.Beans.NeighborhoodDto;
import com.example.demo.Beans.ParkingSlotDto;
import com.example.demo.Beans.ParkingZoneDto;
import com.example.demo.entities.City;
import com.example.demo.entities.Neighborhood;
import com.example.demo.entities.ParkingSlot;
import com.example.demo.entities.ParkingZone;
import com.example.demo.exceptions.ParkingSlotExistsException;
import com.example.demo.projections.ParkingSlotSummary;
import com.example.demo.repositories.CityRepository;
import com.example.demo.repositories.NeighborhoodRepository;
import com.example.demo.repositories.ParkingSlotRepository;
import com.example.demo.repositories.ParkingZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimulationDataService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Autowired
    private ParkingZoneRepository parkingZoneRepository;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Transactional
    public void insertData(List<CityDto> citiesDto) throws ParkingSlotExistsException {
        for (CityDto cityDto : citiesDto) {
            Optional<City> cityRepo = cityRepository.findByName(cityDto.getName());
            City city = cityRepo.orElse(new City(cityDto.getName(), new ArrayList<Neighborhood>()));
            for (NeighborhoodDto neighborhoodDto : cityDto.getNeighborhoods()) {
                Optional<Neighborhood> neighborhoodRepo = neighborhoodRepository
                        .findByNameAndCityName(neighborhoodDto.getName(), cityDto.getName());
                Neighborhood neighborhood = neighborhoodRepo
                        .orElse(new Neighborhood(neighborhoodDto.getName(), city, new ArrayList<ParkingZone>()));
                if (!neighborhoodRepo.isPresent()) {
                    city.getNeighborhoods().add(neighborhood);
                }
                for (ParkingZoneDto parkingZoneDto : neighborhoodDto.getParkingZones()) {
                    Optional<ParkingZone> zoneRepo = parkingZoneRepository
                            .getZoneByZoneNeighCity(parkingZoneDto.getZoneIdent(), neighborhoodDto.getName(), cityDto.getName());
                    ParkingZone parkingZone = zoneRepo
                            .orElse(new ParkingZone(parkingZoneDto.getZoneIdent(), neighborhood, new ArrayList<ParkingSlot>()));
                    if (!zoneRepo.isPresent()) {
                        neighborhood.getParkingZones().add(parkingZone);
                    }
                    for (ParkingSlotDto parkingSlotDto : parkingZoneDto.getParkingSlots()) {
                        Optional<ParkingSlotSummary> slotRepo = parkingSlotRepository
                                .getSlotBySlotZoneNeighCity(
                                        parkingSlotDto.getSlotIdent(), parkingZoneDto.getZoneIdent(),
                                        neighborhoodDto.getName(), cityDto.getName());
                        if (slotRepo.isPresent()) {
                            throw new ParkingSlotExistsException(
                                    String.format("Parking slot %s already exists", slotRepo.get().getSlotIdent()));
                        }
                        ParkingSlot parkingSlot = new ParkingSlot(parkingSlotDto.getSlotIdent(),
                                parkingSlotDto.getState(),
                                parkingSlotDto.getLatitude(),
                                parkingSlotDto.getLongitude(),
                                parkingZone);
                        parkingZone.getParkingSlots().add(parkingSlot);
                    }
                }
            }
            cityRepository.save(city);
        }
    }
}
