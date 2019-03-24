package com.chukyotech.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


    public void insertUser(String userName, int userAge, String userPhone, String userAdress,
                           String userLanguage, String userEmail) {
        userMapper.insertUser(userName, userAge, userPhone, userAdress, userLanguage, userEmail);
    }
}
