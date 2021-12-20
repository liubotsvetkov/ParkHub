package com.example.parkhub.sensorHandlerModule.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimUpdateData {
    private int state;
    private double latitude;
    private double longitude;
}
