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
    public boolean insertData(@RequestBody List<CityDto> cities) throws ParkingSlotExistsException {
        simulationDataService.insertData(cities);
        return true;
    }
}
