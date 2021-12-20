package com.example.parkhub.parkingDataModule.services;

import com.example.parkhub.parkingDataModule.data.ParkingData;
import com.example.parkhub.parkingDataModule.pojos.CityDto;
import com.example.parkhub.parkingDataModule.projections.CitySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    ParkingData parkingData;

    @Override
    public Collection<CitySummary> getAllCities() {
        return parkingData.getAllCities();
    }

    @Override
    public void setCity(List<CityDto> citiesDto) {

    }
}
