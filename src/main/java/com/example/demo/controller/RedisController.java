package com.example.demo.controller;

import com.example.demo.service.Redis.RedisService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private RedisService redisService;

    @GetMapping("/getRedis")
    public Result<Object> getRedisData () {
        return ResultUtil.success();
    }

    @PostMapping
    public Result<Object> setRedisData () {
        return ResultUtil.success();
    }
}
