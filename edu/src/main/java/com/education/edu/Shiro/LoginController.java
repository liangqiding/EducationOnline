package com.education.edu.Shiro;

import com.education.edu.pojo.User;
import com.education.edu.service.imp.UserServiceImp;
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
    @RequestMapping("login")
    public String login(User user, Model model, HttpSession session){
//        1.创建subject
        Subject subject = SecurityUtils.getSubject();
//        2.封装用户
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
//         3.执行登录方法
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在！");
            model.addAttribute("msg","用户名不存在！");
            return "login";

        } catch (IncorrectCredentialsException e) {
            System.out.println("");
            model.addAttribute("msg","密码错误！");
            return "login";
        }
        System.out.println("登陆成功");
        User user1 = userServiceImp.SelectUserByUsername(user.getUsername());
        session.setAttribute("user",user1);
        return "index";
    }

}
