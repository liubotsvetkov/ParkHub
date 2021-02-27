package com.example.demo.repository;

import com.example.demo.models.ParkingZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingZoneRepository extends JpaRepository<ParkingZone, Integer> {
}
