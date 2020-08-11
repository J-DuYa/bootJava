package com.example.demo.service.User.impl;

import com.example.demo.entry.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void signup(User user) {
        userMapper.signup(user);
    }

    public static boolean isEmpty(Object obj) {
        return (obj == null || "".equals(obj));
    }

    @Override
    public Boolean login(String username, String password) {
		try {
			Map userInfo = userMapper.login(username, password);
			System.out.println("******: " + userInfo);
			if (isEmpty(userInfo)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
    }
}
