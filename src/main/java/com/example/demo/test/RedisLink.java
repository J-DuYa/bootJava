package com.example.demo.test;

import redis.clients.jedis.Jedis;

public class RedisLink {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("tutorial-name", "redis tutorial");
        System.out.println("Server is running " + jedis.get("tutorial-name"));
    }
}
