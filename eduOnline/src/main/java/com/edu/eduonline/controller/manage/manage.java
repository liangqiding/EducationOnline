package com.edu.eduonline.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/2/29 0029 14:13
 * @Description: TODO 负责后台管理网页跳转
 */
@Controller
@RequestMapping("/manage")
public class manage {
    //    跳转后台管理
    @RequestMapping("/index")
    public String index() {
        return "manage/index";
    }

    //    跳转教学列表
    @RequestMapping("/table")
    public String table() {
        return "manage/table";
    }

    //    跳转视频详情 携带ID跳转
    @RequestMapping("/table_chapter")
    public String table_chapter(HttpSession session,Integer course_id) {
        session.setAttribute("course_id",course_id);
        return "manage/table_chapter";
    }

    //    跳转个人信息
    @RequestMapping("/personal")
    public String personal() {
        return "manage/personal";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 跳转订单
     * @Date 16:42 2020/3/18 0018
     * @Param 
     * @return 
    **/
    @RequestMapping("/order")
    public String order() {
        return "manage/order";
    }

    @RequestMapping("/user")
    public String user() {
        return "manage/user";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 网站流量分析
     * @Date 14:55 2020/3/19 0019
     * @Param
     * @return
    **/
    @RequestMapping("/rate")
    public String rate() {
        return "manage/rate";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 投稿审核
     * @Date 9:37 2020/3/26 0026
     * @Param 
     * @return 
    **/
    @RequestMapping("/assessor")
    public String assessor() {
        return "manage/assessor";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 审核详情页
     * @Date 9:46 2020/3/26 0026
     * @Param
     * @return
    **/
    @RequestMapping("/assessor_chapter")
    public String assessor_chapter(HttpSession session,Integer course_id) {
        session.setAttribute("course_id",course_id);
        return "manage/assessor_chapter";
    }

}
