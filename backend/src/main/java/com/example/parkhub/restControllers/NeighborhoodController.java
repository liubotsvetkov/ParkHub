package com.example.parkhub.restControllers;

import com.example.parkhub.parkingDataModule.projections.NeighborhoodSummary;
import com.example.parkhub.parkingDataModule.services.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/neighborhoods")
public class NeighborhoodController {

    @Autowired
    NeighborhoodService neighborhoodService;

    @GetMapping("/byCity/{cityId}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Collection<NeighborhoodSummary> viewNeighborhoodsByCity(@PathVariable int cityId) {
        Collection<NeighborhoodSummary> neighborhoods = neighborhoodService.getAllNeighborhoodsByCity(cityId);
        return neighborhoods;
    }
}
