package com.example.parkhub.sensorHandlerModule.services;

import com.example.parkhub.parkingDataModule.data.springData.repositories.ParkingSlotRepository;
import com.example.parkhub.sensorHandlerModule.utilities.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class MessageProcessorFactory {

    @Autowired
    private ApplicationContext appContext;

    public MessageProcessor getMessageProcessor() {
        return new MessageProcessorImpl(BeanUtil.getApplicationContext().getBean(ParkingSlotRepository.class));
    }
}
