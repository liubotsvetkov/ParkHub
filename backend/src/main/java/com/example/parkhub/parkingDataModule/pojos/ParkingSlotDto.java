package com.example.parkhub.parkingDataModule.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlotDto {
    private String slotIdent;
    private int state;
    private double latitude;
    private double longitude;
}
