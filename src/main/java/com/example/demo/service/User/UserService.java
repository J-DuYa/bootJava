package com.example.demo.service.User;

import com.example.demo.entry.User;

public interface UserService {

    void signup(User user);

    Boolean login(String username, String password);
}
