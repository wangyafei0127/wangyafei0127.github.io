package com.chukyotech.server.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Getter
    @Setter
    private String adminName;

    public Admin selectByName(String name) {
        return adminMapper.selectByName(name);
    }

    public void insertAdmin(String adminName, String adminPass) {
        adminMapper.insertAdmin(adminName, adminPass);
    }

    public String login(Admin admin, HttpServletResponse response) throws IOException {
        if (loginValidation(admin.getAdminName(), admin.getAdminPass())) {
            setAdminName(admin.getAdminName());
            response.sendRedirect("home");
        }
        return "管理员账户密码不正确！";
    }

    private boolean loginValidation(String name, String pass) {
        if (name == null || "".equals(name) || pass == null || "".equals(pass)) {
            return false;
        }
        String passFromDB = selectByName(name).getAdminPass();
        return pass.equals(passFromDB);
    }

    public ModelAndView home(Map<String, Object> map) {
        map.put("adminName", getAdminName());
        return new ModelAndView("home", map);
    }
}
