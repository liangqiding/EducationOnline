package com.edu.eduonline.controller.login;

import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.UserServiceImp;
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
    @Autowired
    private GetDateImp getDateImp;
    //注册
    @RequestMapping("doregister")
    @ResponseBody
    public String register(User user, Model model) {
        System.out.println("register:" + user);
        user.setDate(getDateImp.getDate());
        User user1 = userServiceImp.SelectUserByUsername(user.getUsername());
        if (user1 != null) {
            return "用户名已存在";
        }
        String pas = encryptPassword("MD5", user.getPassword(), "lqd", 2);
        user.setPassword(pas);
        int i = userServiceImp.InsterUser(user);
        if (i > 0) {
            return "注册成功";
        } else {
            return "注册失败";
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
