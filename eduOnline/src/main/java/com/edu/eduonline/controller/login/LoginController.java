package com.edu.eduonline.controller.login;

import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 08:56
 * @descriptio 门户登陆相关 redirect
 */
@Controller
public class LoginController {
    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping("/dologin")
    public String login(User user, HttpSession session,Model model) {
//        1.创建subject
        Subject subject = SecurityUtils.getSubject();
//        2.封装用户
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
//         3.执行登录方法
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","账号错误");
            return "/login/login";

        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "/login/login";
        }
        User user1 = userServiceImp.SelectUserByUsername(user.getUsername());
        session.setAttribute("user", user1);
        return "/main/index_grid";
    }

    @RequestMapping("/login/checkUsername")
    @ResponseBody
    public String Test(String username) {
        User user = userServiceImp.SelectUserByUsername(username);
        if (user!=null){
            return "1";
        }
        return "0";
    }
}
