package com.example.demo.kafka;

import com.example.demo.Beans.SimUpdateData;
import com.example.demo.entities.ParkingSlot;
import com.example.demo.exceptions.ParkingSlotNotFoundException;
import com.example.demo.repositories.ParkingSlotRepository;
import com.example.demo.utilities.BeanUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class ConsumerLoop implements Runnable {
    private final KafkaConsumer<String, SimUpdateData> consumer;
    private final List<String> topics;
    private final int id;
    private ParkingSlotRepository parkingSlotRepository;

    @Value("${KAFKA_HOST}")
    private String kafkaHost;

    public ConsumerLoop(int id, String groupId, List<String> topics) {
        this.id = id;
        this.topics = topics;
        this.parkingSlotRepository = BeanUtil.getBean(ParkingSlotRepository.class);
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaHost);
        props.put("group.id", groupId);
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", KafkaJsonDeserializer.class.getName());
        this.consumer = new KafkaConsumer<>(props, new StringDeserializer(),
                new KafkaJsonDeserializer<SimUpdateData>(SimUpdateData.class));
    }

    @Override
    public void run() {
        try {
            consumer.subscribe(topics);

            while (true) {
                ConsumerRecords<String, SimUpdateData> updateData = consumer.poll(Duration.ofMillis(Long.MAX_VALUE));
                this.processMessages(updateData);
            }
        } catch (WakeupException | ParkingSlotNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    private void processMessages(ConsumerRecords<String, SimUpdateData> updateData) throws ParkingSlotNotFoundException {
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

    public void shutdown() {
        consumer.wakeup();
    }
}