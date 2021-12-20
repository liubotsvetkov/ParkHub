package com.example.parkhub.restControllers;

import com.example.parkhub.parkingDataModule.projections.ParkingSlotSummary;
import com.example.parkhub.parkingDataModule.services.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/parkingSlots")
public class ParkingSlotController {

    @Autowired
    ParkingSlotService parkingSlotService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<ParkingSlotSummary> viewAllParkingSlots() {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotService.getAllParkingSlots();
        return parkingSlots;
    }

    @GetMapping("/{slotId}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Optional<ParkingSlotSummary> viewParkingSlot(@PathVariable int slotId) {
        Optional<ParkingSlotSummary> parkingSlot = parkingSlotService.getParkingSlot(slotId);
        return parkingSlot;
    }

    @GetMapping("/byCity/{cityId}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<ParkingSlotSummary> viewParkingSlotByCity(@PathVariable int cityId) {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotService.getParkingSlotsByCity(cityId);
        return parkingSlots;
    }

    @GetMapping("/byNeighborhood/{neighborhoodId}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<ParkingSlotSummary> viewParkingSlotByNeighborhood(@PathVariable int neighborhoodId) {
        Collection<ParkingSlotSummary> parkingSlots = parkingSlotService.getParkingSlotsByNeighborhood(neighborhoodId);
        return parkingSlots;
    }
}
