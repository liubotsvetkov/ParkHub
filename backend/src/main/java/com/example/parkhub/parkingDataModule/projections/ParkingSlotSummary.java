package com.example.parkhub.parkingDataModule.projections;

import java.util.Date;

public interface ParkingSlotSummary {

    int getId();

    String getSlotIdent();

    Date getDateTimeUpdated();

    int getState();

    double getLatitude();

    double getLongitude();

    NeighborhoodSummary getNeighborhood();

    interface NeighborhoodSummary {

        int getId();

        CitySummary getCity();

        interface CitySummary {

            int getId();
        }
    }
}

