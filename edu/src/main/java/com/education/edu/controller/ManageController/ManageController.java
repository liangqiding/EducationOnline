package com.education.edu.controller.ManageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 16:56
 * @descriptio 课程管理
 */
@Controller
public class ManageController {
    @RequestMapping("/manage")
    public String manage(){
        return "manage/index";
    }


    @RequestMapping("/managetable")
    public String managetable(Integer id, HttpSession session){
//        c_chapter_id =id
        if (id!=null){
            session.setAttribute("id",id);
            return "manage/table-basic2";
        }
        return "manage/table-basic";
    }
}
