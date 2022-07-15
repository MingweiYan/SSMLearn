package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
