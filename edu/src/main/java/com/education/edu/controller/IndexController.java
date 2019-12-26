package com.education.edu.controller;

import com.education.edu.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 09:56
 * @descriptio 默认跳转
 */
@Controller
public class IndexController {

   @RequestMapping("/")
    public String index(){
        return "login";
    }


    @RequestMapping("/index")
    public String indexmain(HttpSession session){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        return "index";
    }
//安全退出
    @RequestMapping("/exit")
    public String exit(){

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
    @RequestMapping("/loginm")
    public String loginm(HttpSession session){
        return "login";
    }
    @RequestMapping("/registerm")
    public String register(HttpSession session){
        return "register";
    }
    @RequestMapping("/person")
    public String person(){
        return "manage/pages-profile";
    }

}
