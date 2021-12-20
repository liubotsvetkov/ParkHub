package com.example.parkhub.parkingDataModule.services;

import com.example.parkhub.parkingDataModule.data.ParkingData;
import com.example.parkhub.parkingDataModule.pojos.NeighborhoodDto;
import com.example.parkhub.parkingDataModule.projections.NeighborhoodSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    @Autowired
    ParkingData parkingData;

    @Override
    public Collection<NeighborhoodSummary> getAllNeighborhoodsByCity(int cityId) {
        return parkingData.getAllNeighborhoodsByCity(cityId);
    }

    @Override
    public void setNeighborhood(List<NeighborhoodDto> neighborhoodDto) {

    }
}
