package com.example.demo.repository;

import com.example.demo.models.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {
    List<ParkingSlot> findBySlotIdentAndParkingZoneZoneIdent(String slotIdent, String zoneIdent);
}
