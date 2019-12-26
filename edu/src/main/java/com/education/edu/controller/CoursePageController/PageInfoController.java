package com.education.edu.controller.CoursePageController;

import com.education.edu.pojo.Course;
import com.education.edu.service.imp.CourseServiceImp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageInfoController {
    @Autowired
    private CourseServiceImp courseServiceImp;

    //    /Course
    @RequestMapping("/Course")
    @ResponseBody
    public List<Course> Course(Integer pageNum, HttpSession session, String course_name) {

        if (course_name != null) {
            System.out.println("模糊查询 course_name=" + course_name);
            session.setAttribute("mohu", course_name);
        } else {
            String mohu = (String) session.getAttribute("mohu");
            if (mohu != null) {
                course_name=mohu;
            }
        }
        System.out.println("course_name=" + course_name);
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum >= getPageInfo(course_name, 1).getPages()) {
            pageNum = getPageInfo(course_name, 1).getPages();
        }
        session.setAttribute("pageNum", pageNum);
        System.out.println("pageNum=" + pageNum);
        List<Course> c = courseServiceImp.SelectCourse(course_name, pageNum, 4).getList();
        return c;
    }

    //    /page1 页数
    @RequestMapping("/page1")
    @ResponseBody
    public PageInfo<Course> Page(Integer pageNum, HttpSession session) {
        String mohu = (String) session.getAttribute("mohu");

        if (mohu != null) {
            System.out.println("执行模糊分页！");
        }
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum >= getPageInfo(mohu, 1).getPages()) {
            pageNum = getPageInfo(mohu, 1).getPages();
        }
        System.out.println("当前为第" + pageNum + "页");
        PageInfo<Course> pageInfo = getPageInfo(mohu, pageNum);
        System.out.println("pageInfo:x"+pageInfo);
        return pageInfo;
    }
//    判断是否有模糊和分类 返回按钮清楚模糊和分类值
    @RequestMapping("/return")
    @ResponseBody
    public String re(HttpSession session){
//        执行Return
        System.out.println("执行Return");
        session.removeAttribute("mohu");
        return null;
    }
    private PageInfo<Course> getPageInfo(String mohu, Integer pageNum) {
        PageInfo<Course> pageInfo = courseServiceImp.SelectCourse(mohu, pageNum, 4);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
