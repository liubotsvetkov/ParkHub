package com.example.demo.repositories;

import com.example.demo.entities.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Integer> {
    Optional<Neighborhood> findByNameAndCityName(String neighName, String cityName);
}
