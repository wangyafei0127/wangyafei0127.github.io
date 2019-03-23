package com.chukyotech.server.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin selectByName(String name) {
        return adminMapper.selectByName(name);
    }
}
