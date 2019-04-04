package com.chukyotech.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public User selectUserById(@PathVariable("id") int id) {
        return userService.selectUserById(id);
    }

    @PostMapping("/userInsert")
    public ModelAndView insertUser(@ModelAttribute("user") User user, Map<String, Object> map) {
        userService.insertUser(user.getUserName(), user.getUserAge(), user.getUserPhone(), user.getUserAddres(),
                user.getUserLanguage(), user.getUserEmail());
        return userSelect(map);
    }

    @GetMapping("/userRegister")
    public ModelAndView userRegister(Map<String, Object> map) {
        return userService.userRegister(map);
    }

    @GetMapping("/userSelect")
    public ModelAndView userSelect(Map<String, Object> map) {
        return userService.userManager(map);
    }

    @GetMapping("/userUpdatePage")
    public ModelAndView userUpdatePage(Map<String, Object> map) {
        return userService.userUpdatePage(map);
    }

    @PostMapping("/userUpdate")
    public ModelAndView userUpdate(@ModelAttribute("user") User user, Map<String, Object> map) {
        System.out.println(user.getUserAddres());
        userService.updateUser(user.getId(),
                user.getUserName(),
                user.getUserAge(),
                user.getUserPhone(),
                user.getUserAddres(),
                user.getUserLanguage(),
                user.getUserEmail());
        return userSelect(map);
    }

}