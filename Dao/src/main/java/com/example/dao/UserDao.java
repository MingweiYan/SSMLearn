package com.example.dao;

import com.example.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findUserByUsername(String username);
}
