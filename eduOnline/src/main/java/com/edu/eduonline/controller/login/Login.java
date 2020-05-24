package com.edu.eduonline.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/2/29 0029 14:16
 * @Description: TODO 负责登录模块网页跳转
 */
@Controller
public class Login {
//挑战登录页面
    @RequestMapping("/login")
    public String login() {
        return "login/login";
    }
//跳转注册页面
    @RequestMapping("/register")
    public String register() {
        return "login/register";
    }
}
