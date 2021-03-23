package com.example.demo.Beans;

import com.example.demo.models.ParkingZone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
