package com.example.parkhub.parkingDataModule.data.springData.repositories;

import com.example.parkhub.parkingDataModule.data.springData.entities.City;
import com.example.parkhub.parkingDataModule.projections.CitySummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<com.example.parkhub.parkingDataModule.data.springData.entities.City, Integer> {

    Optional<CitySummary> findByName(String name);

    Collection<CitySummary> findAllProjectedBy();
}
