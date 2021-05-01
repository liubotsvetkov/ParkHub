package com.example.demo;

import com.example.demo.kafka.ConsumerExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

        ConsumerExecutor consumerExecutor = new ConsumerExecutor();
        consumerExecutor.executeConsumers();
    }
}
