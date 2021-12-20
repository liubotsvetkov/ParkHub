package com.example.parkhub.parkingDataModule.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NeighborhoodDto {
    private String name;
    private List<ParkingSlotDto> parkingSlots;
}
