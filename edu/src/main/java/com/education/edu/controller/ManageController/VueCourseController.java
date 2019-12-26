package com.education.edu.controller.ManageController;

import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.Course;
import com.education.edu.pojo.User;
import com.education.edu.service.ChapterService;
import com.education.edu.service.imp.ChapterServiceImp;
import com.education.edu.service.imp.CourseServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/11/011 15:22
 * @descriptio Vue处理类 删除章节
 */
@RestController
public class VueCourseController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private ChapterServiceImp chapterServiceImp;

    //    课程管理目录
    @RequestMapping("/AMCourse")
    public List ACourse() {
        System.out.println("/ACourse");
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println("/ACourse,user id="+user.getUser_id());
        List<Course> courses = courseServiceImp.SelectAllCourseByUserId(user.getUser_id());
        System.out.println("/ACourse:"+courses);
        return courses;
    }
    //    章节管理目录  删除
    @RequestMapping("/AMChapter")
    public List AChapter(Integer course_cha_id,Integer cha_id, HttpSession session) {
        if (cha_id>0){
//            执行删除操作
            int i = chapterServiceImp.DeleteChapterByChap_id(cha_id);
        }
        System.out.println("/AChapter");
        Integer id = (Integer) session.getAttribute("id");
        List<Chapter> chapters = chapterServiceImp.SelectChapterAllById(id);
        System.out.println("/AChapter:"+chapters);
        return chapters;
    }

}
