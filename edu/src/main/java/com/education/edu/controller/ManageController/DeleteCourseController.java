package com.education.edu.controller.ManageController;

import com.education.edu.service.DeleteCourseService;
import com.education.edu.service.imp.ChapterServiceImp;
import com.education.edu.service.imp.DeleteCourseServiceImp;
import com.education.edu.service.imp.My_planServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/12/012 23:42
 * @descriptio 删除课程 及其子目录下所以章节
 */
@Controller
public class DeleteCourseController {
    @Autowired
    private DeleteCourseServiceImp deleteCourseServiceImp;

    //    除课程
    @RequestMapping("/DELCourse")
    @ResponseBody
    public String DELCourse(Integer c_chapter_id) {
//        删除课程 及其子目录下所以章节
        int i = deleteCourseServiceImp.DeleteCourseAllBy(c_chapter_id);
        if (i > 0) {
            return "课程删除成功！";
        } else

            return "课程删除失败！";
    }

}
