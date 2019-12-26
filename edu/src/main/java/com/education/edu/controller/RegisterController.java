package com.education.edu.controller;

import com.education.edu.pojo.User;
import com.education.edu.service.imp.UserServiceImp;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/12/012 11:25
 * @descriptio 注册
 */
@Controller
public class RegisterController {
    @Autowired
    private UserServiceImp userServiceImp;

    //注册
    @RequestMapping("register")
    public String register(User user, Model model) {
        System.out.println("register:" + user);
        User user1 = userServiceImp.SelectUserByUsername(user.getUsername());
        if (user1 != null) {
            System.out.println(user1);
            model.addAttribute("msg", "注册失败," + user.getUsername() + "  用户名已经存在！");
            return "register";
        }
        System.out.println("pass=" + user.getPassword());
        String pas = encryptPassword("MD5", user.getPassword(), "lqd", 2);
        user.setPassword(pas);
        int i = userServiceImp.InsterUser(user);
        if (i > 0) {
            model.addAttribute("sec", "注册成功！");
            System.out.println("插入条数：" + i);
            return "register";
        } else {
            model.addAttribute("msg", "注册失败！");
            return "register";
        }

    }

    @RequestMapping("/RigTest")
    @ResponseBody
    public String RigTest(String username) {
        User user1 = userServiceImp.SelectUserByUsername(username);
        if (user1 != null) {
            System.out.println("账号已经存在");
            return "账号已经存在！";
        }
        return null;
    }


    public static String encryptPassword(String hashAlgorithm, String password, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash(hashAlgorithm, password, salt, hashIterations);
        return hash.toString();
    }
}
