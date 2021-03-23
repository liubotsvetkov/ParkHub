package com.example.demo.controllers;

import com.example.demo.projections.ParkingSlotSummary;
import com.example.demo.services.ParkingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/parkingData")
public class ParkingDataController {

    @Autowired
    ParkingDataService parkingDataService;

    @GetMapping("/viewAll")
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<ParkingSlotSummary> viewAllParkingSlots() {
        Collection<ParkingSlotSummary> parkingSlots = parkingDataService.viewAllParkingSlots();
        return parkingSlots;
    }

    @GetMapping("/city")
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<ParkingSlotSummary> viewParkingSlotByCity(@RequestParam("city") String cityName) {
        Collection<ParkingSlotSummary> parkingSlots = parkingDataService.viewParkingSlotsByCity(cityName);
        return parkingSlots;
    }

    @GetMapping("/neighborhood")
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<ParkingSlotSummary> viewParkingSlotByCityAndNeigh(@RequestParam("city") String cityName,
                                                                        @RequestParam("neighborhood") String neighName) {
        Collection<ParkingSlotSummary> parkingSlots = parkingDataService.viewParkingSlotsByNeighAndCity(neighName, cityName);
        return parkingSlots;
    }

    @GetMapping("/zone")
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<ParkingSlotSummary> viewParkingSlotByCityNeighAndZone(@RequestParam("city") String cityName,
                                                                            @RequestParam("neighborhood") String neighName,
                                                                            @RequestParam("zone") String zoneIdent) {
        Collection<ParkingSlotSummary> parkingSlots = parkingDataService
                .viewParkingSlotsByZoneNeighAndCity(zoneIdent, neighName, cityName);
        return parkingSlots;
    }

    @GetMapping("/slot")
    @CrossOrigin(origins = "http://localhost:8080")
    public Optional<ParkingSlotSummary> viewParkingSlotByCityNeighZoneAndSlot(@RequestParam("city") String cityName,
                                                                              @RequestParam("neighborhood") String neighName,
                                                                              @RequestParam("zone") String zoneIdent,
                                                                              @RequestParam("slot") String slotIdent) {
        Optional<ParkingSlotSummary> parkingSlot = parkingDataService
                .viewParkingSlotsBySlotZoneNeighAndCity(slotIdent, zoneIdent, neighName, cityName);
        return parkingSlot;
    }
}
