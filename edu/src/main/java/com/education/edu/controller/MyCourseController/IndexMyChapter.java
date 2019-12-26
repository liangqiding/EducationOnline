package com.education.edu.controller.MyCourseController;

import com.education.edu.pojo.Mycourse;
import com.education.edu.pojo.User;
import com.education.edu.service.imp.MycourseServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/17/017 16:49
 * @descriptio
 */
@Controller
public class IndexMyChapter {
    @Autowired
    private MycourseServiceImp mycourseServiceImp;
    //我的课程
    @RequestMapping("/videos")
    public String video(HttpSession session, Model model){
        model.addAttribute("msg1state","我的课程");
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        Integer user_id=0;
        if (user!=null){
            user_id = user.getUser_id();
        }
        List<Mycourse> list = mycourseServiceImp.SelectOneCourseToMoreMYcourse(user_id);
        Mycourse mycourse=null;
        for (Mycourse my:list) {
            mycourse=my;
            break;
        }
        if (mycourse!=null){
            session.setAttribute("c_chapter_id",mycourse.getC_chapter_id());
        }

        session.setAttribute("msg","我的课程");
        return "video";
    }
}
