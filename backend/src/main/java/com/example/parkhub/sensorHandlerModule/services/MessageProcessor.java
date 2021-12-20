package com.example.parkhub.sensorHandlerModule.services;

import com.example.parkhub.exceptionHandlerModule.ParkingSlotNotFoundException;
import com.example.parkhub.sensorHandlerModule.pojos.SimUpdateData;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public interface MessageProcessor {

    void processMessages(ConsumerRecords<String, SimUpdateData> updateData) throws ParkingSlotNotFoundException;
}
