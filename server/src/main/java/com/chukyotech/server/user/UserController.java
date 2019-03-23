package com.chukyotech.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String handleUser(@ModelAttribute(value = "user") User user, Model model) {
        userService.insertUser(user.getName(), user.getAge(), user.getLanguage(), user.getPhone());
        model.addAttribute("user", user);
        return "user";
    }
}
