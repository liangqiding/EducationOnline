package com.education.edu.controller.IndexVideoController;

import com.education.edu.service.imp.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/12/012 9:38
 * @descriptio 首页
 */
@Controller
public class IndexMainController {
    @Autowired
    private CourseServiceImp courseServiceImp;

    @RequestMapping("/chapter")
    public String course(Integer c_chapter_id, HttpSession session, Model model) {
        session.removeAttribute("mohu");
        model.addAttribute("c_chapter_id",c_chapter_id);
        session.setAttribute("c_chapter_id",c_chapter_id);
        System.out.println(c_chapter_id);
        return "Video";
    }
}
