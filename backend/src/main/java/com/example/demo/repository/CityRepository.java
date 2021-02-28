package com.example.demo.repository;

import com.example.demo.models.City;
import com.example.demo.models.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByName(String name);
}
