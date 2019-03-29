package com.chukyotech.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/home.html")
    public String home() {
        return "home";
    }

    @GetMapping("/adminRegister.html")
    public String adminRegister() {
        return "adminRegister";
    }
}
