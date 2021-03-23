package com.example.demo.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlotDto {
    private String slotIdent;
    private Date dateTimeUpdated;
    private int state;
    private double latitude;
    private double longitude;
}
