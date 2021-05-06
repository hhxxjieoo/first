package com.hhj.controller;


import com.hhj.entity.Account;
import com.hhj.entity.Admin;
import com.hhj.entity.User;
import com.hhj.feign.AccountFeigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/accountClient")
public class AccountClient {

    @Autowired
    private AccountFeigin accountFeigin;

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target) {
        return target;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {
        Account account = accountFeigin.login(username, password, type);
        String target = null;
        if (account == null) {
            session.setAttribute("wrong","用户名或者密码错误！");
            target = "login";
        } else {
            switch (type) {
                case "user":
                    User user = new User();
                    user.setUsername(account.getUsername());
                    user.setPassword(account.getPassword());
                    session.setAttribute("user", user);
                    target = "redirect:/accountClient/redirect/user_main";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    admin.setUsername(account.getUsername());
                    admin.setPassword(account.getPassword());
                    session.setAttribute("admin", admin);
                    target = "redirect:/accountClient/redirect/admin_main";
                    break;
            }
        }
        return target;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
