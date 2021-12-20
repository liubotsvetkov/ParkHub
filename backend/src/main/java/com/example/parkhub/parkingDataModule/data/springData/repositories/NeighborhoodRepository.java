package com.example.parkhub.parkingDataModule.data.springData.repositories;

import com.example.parkhub.parkingDataModule.data.springData.entities.Neighborhood;
import com.example.parkhub.parkingDataModule.projections.NeighborhoodSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Integer> {

    Collection<NeighborhoodSummary> findByCityId(int cityId);
}
