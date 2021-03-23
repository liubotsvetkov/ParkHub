package com.example.demo.Beans;

import com.example.demo.models.ParkingZone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private String name;
    private List<ParkingZoneDto> parkingZones;
}
