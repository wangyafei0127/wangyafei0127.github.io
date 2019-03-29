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

    @GetMapping("/home.html")
    public String home() {
        return "home";
    }

    @GetMapping("/adminRegister.html")
    public String adminRegister() {
        return "adminRegister";
    }

    @GetMapping("404")
    public String page404() {
        return "404";
    }
}
