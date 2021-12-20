package com.example.parkhub.sensorHandlerModule;

import com.example.parkhub.exceptionHandlerModule.ParkingSlotNotFoundException;
import com.example.parkhub.sensorHandlerModule.pojos.SimUpdateData;
import com.example.parkhub.sensorHandlerModule.services.MessageProcessor;
import com.example.parkhub.sensorHandlerModule.services.MessageProcessorFactory;
import com.example.parkhub.sensorHandlerModule.utilities.KafkaJsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ConsumerLoop implements Runnable {
    private final KafkaConsumer<String, SimUpdateData> consumer;
    private final List<String> topics;
    private final int id;
    private MessageProcessor messageProcessor;

    public ConsumerLoop(int id, String groupId, List<String> topics) {
        this.id = id;
        this.topics = topics;
        this.messageProcessor = new MessageProcessorFactory().getMessageProcessor();
        Properties props = new Properties();
        props.put("bootstrap.servers", System.getenv("KAFKA_HOST"));
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
                messageProcessor.processMessages(updateData);
            }
        } catch (WakeupException | ParkingSlotNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    public void shutdown() {
        consumer.wakeup();
    }
}