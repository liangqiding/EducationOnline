package com.education.edu.controller.IndexVideoController;

import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.Course;
import com.education.edu.pojo.Mycourse;
import com.education.edu.pojo.User;
import com.education.edu.service.imp.ChapterServiceImp;
import com.education.edu.service.imp.CourseServiceImp;
import com.education.edu.service.imp.MycourseServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/12/012 9:50
 * @descriptio vue
 */
@RestController
public class AjaxVueIndex {
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private MycourseServiceImp mycourseServiceImp;
//根据UID查询我的课程目录
    @RequestMapping("/AIChapter")
    public List Mycourse(Integer course_cha_id,HttpSession session) {
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        if (user==null){
            return null;
        }
        List<Chapter> chapters=null;
        if (course_cha_id!=null){
            chapters=chapterServiceImp.SelectChapterAndMy_Plan(user.getUser_id(),course_cha_id);
            System.out.println("直接播放"+course_cha_id+chapters);
             return chapters;
        }
        course_cha_id = (Integer) session.getAttribute("c_chapter_id");
        session.setAttribute("c_chapter_id",course_cha_id);
      chapters=chapterServiceImp.SelectChapterAndMy_Plan(user.getUser_id(),course_cha_id);
        System.out.println("根据学习进度播放，我的课程目录："+chapters);
        return chapters;
    }

}
