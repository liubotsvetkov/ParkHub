package com.example.demo.controllers;

import com.example.demo.Beans.*;
import com.example.demo.exceptions.ParkingSlotExistsException;
import com.example.demo.services.SimulationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/simulationData")
public class SimulationDataController {

    @Autowired
    private SimulationDataService simulationDataService;

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public long insertData(@RequestBody List<CityDto> cities) throws ParkingSlotExistsException {
        long parkingSlotCount = simulationDataService.insertData(cities);
        return parkingSlotCount;
    }

    /**
    @PutMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String updateData(@RequestBody List<SimUpdateData> updateData) {
        for (SimUpdateData data : updateData) {
            List<ParkingSlot> parkingSlots =
                    parkingSlotRepository.findBySlotIdentAndParkingZoneZoneIdent(data.getSlot_id(), data.getParking());
            if (!parkingSlots.isEmpty()) {
                parkingSlots.get(0).setState(data.getState());
                parkingSlots.get(0).setDateTimeUpdated(new Date());
            }
            else {
                throw new IllegalArgumentException();
            }
            parkingSlotRepository.save(parkingSlots.get(0));
        }
        return "success";
    }*/
}
