package com.edu.eduonline.controller.main.My;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/12 0012 15:36
 * @Description: TODO
 */
@Controller
@RequestMapping("/vip")
public class My {
    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 跳转个人信息页面
     * @Date 15:38 2020/3/12 0012
     * @Param
     **/
    @RequestMapping("/personal")
    public String personal() {
        return "main/my/index";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 跳转我的收藏
     * @Date 15:54 2020/3/12 0012
     * @Param
     **/
    @RequestMapping("/myLike")
    public String mylike() {
        return "main/my/myLike";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 学习中心
     * @Date 14:19 2020/3/13 0013
     * @Param
     **/
    @RequestMapping("/study")
    public String study() {
        return "main/my/study";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 个人信息
     * @Date 14:09 2020/3/16 0016
     * @Param
     **/
    @RequestMapping("/personal2")
    public String personal2() {
        return "main/my/personal";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 跳转我的投稿
     * @Date 14:02 2020/3/18 0018
     * @Param
     **/
    @RequestMapping("/mySubmit")
    public String mySubmit() {
        return "main/my/mySubmit";
    }

    @RequestMapping("/Subscribe")
    public String Subscribe() {
        return "main/my/Subscribe";
    }

    //    跳转动态
    @RequestMapping("/trends")
    public String trends() {
        return "main/my/trends";
    }
}
