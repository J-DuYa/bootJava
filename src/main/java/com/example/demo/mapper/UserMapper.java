package com.example.demo.mapper;

import com.example.demo.entry.User;

import java.util.Map;

public interface UserMapper {

	void signup(User user);

	Map<String, Object> login(String username, String password);
}
