package com.example.parkhub;

import com.example.parkhub.sensorHandlerModule.ConsumerExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        ConsumerExecutor.executeConsumers();
    }
}
