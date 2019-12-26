package com.education.edu.controller.MyCourseController;

import com.education.edu.pojo.Course;
import com.education.edu.pojo.Mycourse;
import com.education.edu.pojo.User;
import com.education.edu.service.imp.ChapterServiceImp;
import com.education.edu.service.imp.CourseServiceImp;
import com.education.edu.service.imp.MycourseServiceImp;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/16/016 17:39
 * @descriptio 查询我的课程
 */
@RestController
public class VueSelectMycourse {
    @Autowired
    private MycourseServiceImp mycourseServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;

    //    返回我的课程信息
    @RequestMapping("/SelMyCourse")
    public List<Mycourse> AddMyCourse(HttpSession session) {
        User user = (User) session.getAttribute("user");
        PageInfo<Mycourse> pageInfo = mycourseServiceImp.SelectMyCourseByUid(user.getUser_id(), 1);
        List<Mycourse> list = pageInfo.getList();
        System.out.println(list);
        return list;
    }

    //    Mycourse一对多查询课程目录chapter
    @RequestMapping("/SelMyCourseAndChapter")
    public List<Mycourse> SELMyCourse(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Mycourse> list = null;
        if (user!=null) {
            list = mycourseServiceImp.SelectOneCourseToMoreMYcourse(user.getUser_id());
        }
        System.out.println("MyCourseAndChapter:" + list);
        return list;
    }

    //    /SelectCourse
    @RequestMapping("/SelectCourse")
    public Course SelectCourse(Integer c_chapter_id, HttpSession session) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (c_chapter_id!=null) {
            session.setAttribute("c_chapter_id", c_chapter_id);
        }
        if(user==null){
            return null;
        }
//        用户直接点击课程学习
        if (c_chapter_id != null) {
            Course course = courseServiceImp.SelectCourseByC_chapter_id(c_chapter_id);
            session.setAttribute("msg","学习中心");
            System.out.println("学习中心:" + course);
            return course;
        }
        //        用户通过我的课程进入学习
        List<Course> course1 = courseServiceImp.SelectAllCourseByUserId(user.getUser_id());
        Course course = null;
        for (Course course2 : course1) {
            course = course2;
            break;
        }
        System.out.println("切换课程学习-我的课程:" + course);
        session.setAttribute("msg","我的课程");
        return course;
    }
}
