package com.example.demo.Kafka;

import com.example.demo.dto.KafkaMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
@Slf4j
public class KafkaSender {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private Gson gson = new GsonBuilder().create();

    public void send (String msg) {
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(System.currentTimeMillis());
        kafkaMessage.setMsg(msg);
        kafkaMessage.setSendTime(new Date());
        log.info("【++++++++++++++++++ message ：{}】", gson.toJson(kafkaMessage));
        kafkaTemplate.send("Hello", gson.toJson(kafkaMessage));
    }

//    @KafkaListener(topics = {"Hello"}, groupId = "shuang")
//    public void listen(ConsumerRecord<?, ?> record) {
//        Optional.ofNullable(record.value())
//                .ifPresent(message -> {
//                    log.info("【+++++++++++++++++ record = {} 】", record);
//                    log.info("【+++++++++++++++++ message = {}】", message);
//                });
//    }
}
