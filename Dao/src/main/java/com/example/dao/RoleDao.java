package com.example.dao;

import com.example.pojo.Role;
import com.example.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleDao {
    Set<Role> findRolesByUserId(Integer userId);
}
