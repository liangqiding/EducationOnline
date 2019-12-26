package com.education.edu.controller.MyCourseController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/17/017 15:03
 * @descriptio
 */
@RestController
public class State {

//    VideoState
    @RequestMapping("/VideoState")
    public String state(HttpSession session,String sta){
        if(sta!=null){
            session.setAttribute("msg",sta);
            System.out.println("sta:"+sta);
            return sta;
        }
        String msg= (String) session.getAttribute("Vstate");
        if (msg!=null){
            System.out.println("执行了1");
        return msg;
        }
        System.out.println("执行了2");
        return "学习中心";
    }
}
