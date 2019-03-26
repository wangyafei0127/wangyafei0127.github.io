package com.chukyotech.server.user;

import com.chukyotech.server.controller.PageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String insertUser(@ModelAttribute("user") User user, Model model) {
        userService.insertUser(user.getUserName(), user.getUserAge(), user.getUserPhone(), user.getUserAddres(),
                user.getUserLanguage(), user.getUserEmail());
        return userSelect(model);
    }

    @GetMapping("/userRegister")
    public String userRegister() {
        return "userRegister";
    }

    @GetMapping("/userSelect")
    public String userSelect(Model model) {
        model.addAttribute("userList", userService.selectUsers());
        return "userSelect";
    }

    @GetMapping("/userUpdatePage")
    public String userUpdatePage() {
        return "userUpdatePage";
    }

    @PostMapping("/userUpdate")
    public String userUpdate(@ModelAttribute("user") User user, Model model) {
        System.out.println(user.getUserAddres());
        userService.updateUser(user.getId(),
                user.getUserName(),
                user.getUserAge(),
                user.getUserPhone(),
                user.getUserAddres(),
                user.getUserLanguage(),
                user.getUserEmail());
        return userSelect(model);
    }
}
