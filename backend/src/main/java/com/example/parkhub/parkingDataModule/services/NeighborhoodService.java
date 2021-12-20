package com.example.parkhub.parkingDataModule.services;

import com.example.parkhub.parkingDataModule.pojos.NeighborhoodDto;
import com.example.parkhub.parkingDataModule.projections.NeighborhoodSummary;

import java.util.Collection;
import java.util.List;

public interface NeighborhoodService {

    Collection<NeighborhoodSummary> getAllNeighborhoodsByCity(int cityId);

    void setNeighborhood(List<NeighborhoodDto> neighborhoodDto);
}
