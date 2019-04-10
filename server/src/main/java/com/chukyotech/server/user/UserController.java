package com.chukyotech.server.user;

import com.chukyotech.server.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserMapper mapper;

    @GetMapping("/getUser/{id}")
    public User selectUserById(@PathVariable("id") int id) {
        return userService.selectUserById(id);
    }

    @PostMapping("/userInsert")
    public ModelAndView insertUser(@ModelAttribute("user") User user, Map<String, Object> map) {
        userService.insertUser(user.getUserName(), user.getUserAge(), user.getUserPhone(), user.getUserAddres(),
                user.getUserLanguage(), user.getUserEmail());
        return userManager(map);
    }

    @GetMapping("/userRegisterPage")
    public ModelAndView userRegisterPage(Map<String, Object> map) {
        return userService.userRegisterPage(map);
    }

    @GetMapping("/userSelect")
    public ModelAndView userSelect(Map<String, Object> map) {
        return userService.userSelect(map);
    }

    @GetMapping("/userUpdatePage")
    public ModelAndView userUpdate222(String id, Map<String, Object> map) {
        User user = userService.selectUserById(Integer.parseInt(id));
        map.put("user", user);

        String adminName = adminService.getAdminName();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userUpdatePage");
        modelAndView.addObject("adminName", adminName);
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @PostMapping("/userUpdatePage/userUpdate")
    public void userUpdate(@ModelAttribute("user") User user, Map<String, Object> map, HttpServletResponse response) {
        System.out.println(user.getUserAddres());
        userService.updateUser(user.getId(),
                user.getUserName(),
                user.getUserAge(),
                user.getUserPhone(),
                user.getUserAddres(),
                user.getUserLanguage(),
                user.getUserEmail());
        try {
            response.sendRedirect("/userManager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/userManager")
    public ModelAndView userManager(Map<String, Object> map) {
        return userService.userManager(map);
    }

    @GetMapping("/userDelete")
    public void userDelete(String id, Map<String, Object> map, HttpServletResponse response) {
        Integer userId = Integer.parseInt(id.trim());
        userService.userDelete(userId, map);
        try {
            response.sendRedirect("/userManager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("home/login");
    }

}