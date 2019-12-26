package com.education.edu.controller;

import com.education.edu.pojo.Course;
import com.education.edu.service.imp.CourseServiceImp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 13:50
 * @descriptio 课程主页
 */
@Controller
public class CourseController {
    @Autowired
    private CourseServiceImp courseServiceImp;

    @RequestMapping("/course")
    public String course(HttpSession session) {
        PageInfo<Course> pageInfo = courseServiceImp.SelectCourse(null,1, 4);
        List<Course> c=pageInfo.getList();
        int pageNum = pageInfo.getPageNum();
        session.setAttribute("pageNum",pageNum);
        System.out.println(c);
        return "index";
    }
}
