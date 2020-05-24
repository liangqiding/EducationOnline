package com.edu.eduonline.controller.manage.Course;

import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.Page;
import com.edu.eduonline.service.imp.CourseServiceImp;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.SaveFileServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/18 0018 14:55
 * @Description: TODO
 */
@Controller
@RequestMapping("/manage")
public class UpdateCourseController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private GetDateImp getDateImp;
    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 修改课程
     * @Date 16:36 2020/3/17 0017
     * @Param
     **/
    @RequestMapping("/UdpCourse")
    public String udpChapter2(Course course, @RequestParam("file") MultipartFile file) throws Exception {
        int u_id = userServiceImp.getShiro_U_id();
        String newVidoeName = null;
        if (u_id == 0) {
            return "login/login";
        }
        if (!file.isEmpty()) {
            newVidoeName = saveFileServiceImp.saveImages_File(file, "course");
            saveFileServiceImp.deleteImages_File("course",course.getImg());
        }

        course.setImg(newVidoeName)
                .setU_id(u_id)
                ;
//    操作数据库
        try {
            courseServiceImp.UdpCourse(course);
            System.out.println("SuccessInsertDB>>>");
        } catch (Exception e) {
            e.printStackTrace();
            return "manage/table_chapter";
        }
        return "manage/table_chapter";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 审核课程
     * @Date 10:06 2020/3/26 0026
     * @Param
     * @return
    **/
    @RequestMapping("/UdpCourseAss")
    public String UdpCourseAss(Course course, @RequestParam("file") MultipartFile file) throws Exception {
        int u_id = userServiceImp.getShiro_U_id();
        String newVidoeName = null;
        if (u_id == 0) {
            return "login/login";
        }
        if (!file.isEmpty()) {
            newVidoeName = saveFileServiceImp.saveImages_File(file, "course");
            saveFileServiceImp.deleteImages_File("course",course.getImg());
        }
        course.setImg(newVidoeName)
        ;
//    操作数据库
        try {
            courseServiceImp.UdpCourse(course);
            System.out.println("SuccessInsertDB>>>");
        } catch (Exception e) {
            e.printStackTrace();
            return "manage/assessor_chapter";
        }
        return "manage/assessor_chapter";
    }
}
