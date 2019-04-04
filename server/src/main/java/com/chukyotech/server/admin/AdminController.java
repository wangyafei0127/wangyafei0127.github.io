package com.chukyotech.server.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/adminRegister.html")
    public ModelAndView adminRegister() {
        return new ModelAndView("adminRegister");
    }

    @GetMapping("404")
    public ModelAndView page404() {
        return new ModelAndView("404");
    }

    @GetMapping("/home")
    public ModelAndView home(Map<String, Object> map) {
        return adminService.home(map);
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("admin") Admin admin, HttpServletResponse response) throws IOException {
        return adminService.login(admin, response);
    }

    @PostMapping("/adminRegister")
    public ModelAndView adminRegister(@ModelAttribute("admin") Admin admin) {
        adminService.insertAdmin(admin.getAdminName(), admin.getAdminPass());
        return login();
    }

    @GetMapping("/menu")
    public ModelAndView menu() {
        return new ModelAndView("menu");
    }
}
