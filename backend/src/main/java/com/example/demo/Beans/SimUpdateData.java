package com.example.demo.Beans;

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
    private String last_up;
    private String parking;
    private String slot_id;
}
