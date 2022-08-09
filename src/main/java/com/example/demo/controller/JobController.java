package com.example.demo.controller;

import com.example.demo.Kafka.KafkaSender;
import com.example.demo.service.Job.JobService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/job")
public class JobController {

    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private KafkaSender kafkaSender;

    @Autowired
    private JobService jobService;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public JobController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // 查询任务列表
    @GetMapping("/list")
    public Result<Object> getJobList() {
        // 获取Job List
        List<Map<Object, String>> resultMap = new ArrayList<Map<Object, String>>();
        Map<Object, String> map = new HashMap<Object, String>();
        map.put("data", null);
        resultMap.add(map);
        return ResultUtil.success(resultMap);
    }

    @GetMapping("/send-message")
    public void getMessage(@RequestParam String msg) {
        kafkaSender.send(msg);
    }

    @GetMapping(path = "/post-message")
    public void getKafkaMessage(@RequestParam String message) {
        logger.info("sending message {}", message);

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("Hello", message);

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("successfully sent message = {}, with offset = {}", message,
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.info("Failed to send message = {}, error = {}", message, ex.getMessage());
            }
        });
    }
}
