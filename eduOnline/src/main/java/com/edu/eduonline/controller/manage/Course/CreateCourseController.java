package com.edu.eduonline.controller.manage.Course;

import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.CourseServiceImp;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.SaveFileServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/3/2 0002 10:26
 * @Description: TODO 添加课程
 */
@Controller
@RequestMapping("/manage")
public class CreateCourseController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    @Autowired
    private GetDateImp getDateImp;

    @RequestMapping("/createCourse")
    public String CreateCourse(Course course, @RequestParam("file") MultipartFile file) throws Exception {
        // 如果文件不为空，写入上传路径
        String newVidoeName = null;
        int u_id = userServiceImp.getShiro_U_id();
        if (u_id == 0) {
            return "login/login";
        }
        if (!file.isEmpty()) {
            newVidoeName = saveFileServiceImp.saveImages_File(file, "course");
        }
        course.setImg(newVidoeName).setCourse_date(getDateImp.getDate()).setU_id(u_id).setState("待发布");
//    操作数据库
        try {
            courseServiceImp.InsertCourse(course);
            System.out.println("SuccessInsertDB>>>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "manage/table";
    }
}

