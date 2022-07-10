package com.example.service.impl;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired


    @Override
    public User findUserByUsername(String username) {
        return null;
    }
}
