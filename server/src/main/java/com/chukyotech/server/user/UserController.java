package com.chukyotech.server.user;

import com.chukyotech.server.controller.PageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PageController pageController;

    @GetMapping("/getUser/{id}")
    public User selectUserById(@PathVariable("id") int id) {
        return userService.selectUserById(id);
    }

    @PostMapping("/userInsert")
    public String insertUser(@ModelAttribute("user") User user) {
        userService.insertUser(user.getUserName(), user.getUserAge(), user.getUserPhone(), user.getUserAddres(),
                user.getUserLanguage(), user.getUserEmail());
        return pageController.home();
    }

    @GetMapping("/userRegister")
    public String userRegister() {
        return "userRegister";
    }
}
