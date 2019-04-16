package com.chukyotech.server.controller;

import com.chukyotech.server.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class ImageController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getImagesPage")
    public ModelAndView getImagesPage() {
        String adminName = adminService.getAdminName();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("imagesPage");
        modelAndView.addObject("adminName", adminName);
        return modelAndView;
    }

    @GetMapping("/getSearchImagesPage")
    public ModelAndView getSearchImagesPage() {
        String adminName = adminService.getAdminName();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchImagesPage");
        modelAndView.addObject("adminName", adminName);
        return modelAndView;
    }

    @GetMapping("/searchImages")
    public ModelAndView searchImage(String content) {
        ModelAndView modelAndView = new ModelAndView();
        String adminName = adminService.getAdminName();
        modelAndView.setViewName("searchImagesPage");
        modelAndView.addObject("adminName", adminName);
        String url = "https://source.unsplash.com/featured/?{" + content + "}";
        modelAndView.addObject("imageUrl", url);
        modelAndView.addObject("searchContent", content);
        return modelAndView;
    }
}
