package com.chukyotech.server.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/select")
    public String select() {
        Admin admin = adminService.selectByName("admin");
        System.out.println(admin.getAdminPass());
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("admin") Admin admin) {
        Admin adminDb = adminService.selectByName(admin.getAdminName());
        String adminPassDb = adminDb.getAdminPass();
        if (admin.getAdminPass().equals(adminPassDb)) {
            return "home";
        }
        return "redirect:/index";
    }

    @GetMapping("/userRegister")
    public String userRegister() {
        return "userRegister";
    }
}
