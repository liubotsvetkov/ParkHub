package com.example.parkhub.parkingDataModule.services;

import com.example.parkhub.parkingDataModule.pojos.CityDto;
import com.example.parkhub.parkingDataModule.projections.CitySummary;

import java.util.Collection;
import java.util.List;

public interface CityService {

    Collection<CitySummary> getAllCities();

    void setCity(List<CityDto> citiesDto);
}
