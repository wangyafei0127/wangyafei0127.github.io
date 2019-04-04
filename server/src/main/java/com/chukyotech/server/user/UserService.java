package com.chukyotech.server.user;

import com.chukyotech.server.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import sun.management.Agent;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminService adminService;

    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectUsers() {
        return userMapper.selectUsers();
    }

    public ModelAndView userSelect(Map<String, Object> map) {
        String adminName = adminService.getAdminName();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userSelect");
        map.put("userList", selectUsers());
        modelAndView.addAllObjects(map);
        modelAndView.addObject("adminName", adminName);
        return modelAndView;
    }

    public ModelAndView userManager(Map<String, Object> map) {
        String adminName = adminService.getAdminName();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userManager");
        map.put("userList", selectUsers());
        modelAndView.addAllObjects(map);
        modelAndView.addObject("adminName", adminName);
        return modelAndView;
    }

    public void insertUser(String userName,
                           Integer userAge,
                           String userPhone,
                           String userAdress,
                           String userLanguage,
                           String userEmail) {
        userMapper.insertUser(userName, userAge, userPhone, userAdress, userLanguage, userEmail);
    }

    public void updateUser(int id,
                           String userName,
                           Integer userAge,
                           String userPhone,
                           String userAdress,
                           String userLanguage,
                           String userEmail) {
        userMapper.updateUser(id, userName, userAge, userPhone, userAdress, userLanguage, userEmail);
    }

    public ModelAndView userRegister(Map<String, Object> map) {
        map.put("adminName", adminService.getAdminName());
        return new ModelAndView("userRegister", map);
    }

    public ModelAndView userUpdatePage(Map<String, Object> map) {
        map.put("adminName", adminService.getAdminName());
        return new ModelAndView("userUpdatePage", map);
    }

    public ModelAndView userDelete(Integer id, Map<String, Object> map) {
        userMapper.deleteByPrimaryKey(id);
        return userManager(map);
    }
}
