package com.example.parkhub.sensorHandlerModule.services;

import com.example.parkhub.exceptionHandlerModule.ParkingSlotNotFoundException;
import com.example.parkhub.parkingDataModule.data.springData.entities.ParkingSlot;
import com.example.parkhub.parkingDataModule.data.springData.repositories.ParkingSlotRepository;
import com.example.parkhub.sensorHandlerModule.pojos.SimUpdateData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MessageProcessorImpl implements MessageProcessor {

    private ParkingSlotRepository parkingSlotRepository;

    public MessageProcessorImpl(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public void processMessages(ConsumerRecords<String, SimUpdateData> updateData) throws ParkingSlotNotFoundException {
        for (ConsumerRecord<String, SimUpdateData> data : updateData) {
            Optional<ParkingSlot> parkingSlot = parkingSlotRepository
                    .findByLatitudeAndLongitude(data.value().getLatitude(), data.value().getLongitude());

            if (parkingSlot.isPresent()) {
                parkingSlot.get().setState(data.value().getState());
                parkingSlot.get().setDateTimeUpdated(new Date());
            } else {
                throw new ParkingSlotNotFoundException(
                        String.format("Parking slot with latitude %f and longitude %f is not found",
                                parkingSlot.get().getLatitude(),
                                parkingSlot.get().getLongitude()));
            }
            parkingSlotRepository.save(parkingSlot.get());
        }
    }
}
