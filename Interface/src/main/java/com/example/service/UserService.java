package com.example.service;

import com.example.pojo.User;

public interface UserService {
    User findUserByUsername(String username);
}
