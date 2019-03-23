package com.chukyotech.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(String name, int age, String language, String phone) {
        userMapper.insert(name, age, language, phone);
    }
}
