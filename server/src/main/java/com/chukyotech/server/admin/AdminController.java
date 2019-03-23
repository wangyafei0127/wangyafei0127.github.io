package com.chukyotech.server.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/select")
    public String select() {
//        Admin admin1 = adminMapper.selectByPrimaryKey(1);
//        System.out.println(admin1);

        Admin admin = adminService.selectByName("admin");
        System.out.println(admin.getAdminPass());
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("admin") Admin admin) {
        return "redirect:/index";
    }
}
