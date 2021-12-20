package com.example.parkhub.parkingDataModule.projections;

public interface NeighborhoodSummary {

    int getId();

    String getName();

    CitySummary getCity();

    interface CitySummary {

        int getId();
    }
}
