package com.education.edu.controller.MyCourseController;

import com.education.edu.pojo.User;
import com.education.edu.service.imp.My_planServiceImp;
import com.education.edu.service.imp.MycourseServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/18/018 14:50
 * @descriptio
 */
@RestController
public class DelMycourse {
    @Autowired
    private MycourseServiceImp mycourseServiceImp;
    @Autowired
    private My_planServiceImp my_planServiceImp;
//    DelMycourse
@RequestMapping("/DelMycourse")
public String state(Integer c_chapter_id){
   User user= (User) SecurityUtils.getSubject().getPrincipal();
//   删除课程
int i=mycourseServiceImp.DeleteMycourseByC_Cha_idandUid(c_chapter_id,user.getUser_id());
//删除课程计划
int b=my_planServiceImp.DelMy_plan(user.getUser_id(),c_chapter_id);
    if (i>0&&b>0) {
        return "删除成功！";
    }
    return "删除失败！";
}
}
