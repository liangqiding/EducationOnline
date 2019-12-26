package com.education.edu.controller.MyCourseController;

import com.education.edu.pojo.Course;
import com.education.edu.pojo.Mycourse;
import com.education.edu.pojo.User;
import com.education.edu.service.imp.CourseServiceImp;
import com.education.edu.service.imp.MycourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 11:54
 * @descriptio 添加课程
 */
@Controller
public class AddMyCourseController {
    @Autowired
    private MycourseServiceImp mycourseServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;

    //    添加课程
    @RequestMapping("/AddMyCourse")
    @ResponseBody
    public String AddMyCourse(Integer c_chapter_id, HttpSession session) {
        System.out.println("/AddMyCourse=" + c_chapter_id);
        User user = (User) session.getAttribute("user");
        if (user==null){
            return "请先登陆！";
        }
        Course course = courseServiceImp.SelectCourseByC_chapter_id(c_chapter_id);
//        1.生成课程表
        Mycourse mycourse = new Mycourse();
        mycourse.setC_chapter_id(c_chapter_id);
//        设置时间
        Date date = new Date();
        SimpleDateFormat sF = new SimpleDateFormat("yyyy-MM-dd");
        String format = sF.format(date.getTime());
        mycourse.setM_date(format);
//        作者
        mycourse.setM_author(course.getAuthor());
//        图片
        mycourse.setM_img(course.getImg());
//        课程名
        mycourse.setM_name(course.getCourse_name());
//        学习进度
        mycourse.setM_plan(0);
//        课程价格
        mycourse.setM_price(0);
//        绑定用户ID
        mycourse.setU_id(user.getUser_id());
        int i = mycourseServiceImp.InsertMyCourse(mycourse,c_chapter_id);
        if (i > 0) {return "添加成功！";
        }
        return "添加失败！";
    }
}
