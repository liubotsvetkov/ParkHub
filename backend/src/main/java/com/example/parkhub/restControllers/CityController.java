package com.example.parkhub.restControllers;

import com.example.parkhub.parkingDataModule.projections.CitySummary;
import com.example.parkhub.parkingDataModule.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<CitySummary> viewAllCities() {
        Collection<CitySummary> cities = cityService.getAllCities();
        return cities;
    }
}
