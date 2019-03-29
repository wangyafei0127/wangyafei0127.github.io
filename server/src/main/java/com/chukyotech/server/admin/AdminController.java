package com.chukyotech.server.admin;

import com.chukyotech.server.controller.PageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PageController pageController;

    @PostMapping("/login")
    public String login(@ModelAttribute("admin") Admin admin) {
        Admin adminDb = adminService.selectByName(admin.getAdminName());
        String adminPassDb = adminDb.getAdminPass();
        if (admin.getAdminPass().equals(adminPassDb)) {
            return "home";
        }
        return "redirect:/home";
    }

    @PostMapping("/adminRegister")
    public String adminRegister(@ModelAttribute("admin") Admin admin) {
        adminService.insertAdmin(admin.getAdminName(), admin.getAdminPass());
        return pageController.login();
    }
}
