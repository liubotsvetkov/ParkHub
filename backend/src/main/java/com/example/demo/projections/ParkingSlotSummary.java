package com.example.demo.projections;

import java.util.Date;

public interface ParkingSlotSummary {
    String getSlotIdent();
    Date getDateTimeUpdated();
    int getState();
    double getLatitude();
    double getLongitude();
    ParkingZoneSummary getParkingZone();

    interface ParkingZoneSummary {
        String getZoneIdent();
        NeighborhoodSummary getNeighborhood();

        interface NeighborhoodSummary {
            String getName();
            CitySummary getCity();

            interface CitySummary {
                String getName();
            }
        }
    }
}
