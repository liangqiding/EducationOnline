package com.edu.eduonline.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/2/29 0029 16:48
 * @Description: TODO 开放权限区
 */
@Controller
public class Index {
    //    跳转登录页面
    @RequestMapping("/logout")
    public String logout() {
        Subject lvSubject= SecurityUtils.getSubject();
        lvSubject.logout();
        return "login/login";
    }
    //    跳转首页
    @RequestMapping("/index")
    public String index(HttpSession session,String name) {
        if (name!=null){
            session.setAttribute("SearchName",name);
        }
        return "main/index_grid";
    }
    //    跳转首页
    @RequestMapping("/")
    public String index_grid() {
        return "main/index_grid";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 切换列表显示
     * @Date 16:48 2020/3/12 0012
     * @Param
     * @return
     **/
    @RequestMapping("/index_list")
    public String Index_list() {
        return "main/Index_list";
    }

    @RequestMapping("/A")
    public String at() {
        return "static/A.html";
    }
}
