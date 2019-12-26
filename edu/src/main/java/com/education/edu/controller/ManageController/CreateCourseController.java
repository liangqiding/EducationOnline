package com.education.edu.controller.ManageController;

import com.education.edu.pojo.Course;
import com.education.edu.pojo.User;
import com.education.edu.service.imp.CourseServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 15:56
 * @descriptio 添加课程
 */
@Controller
public class CreateCourseController {
    @Autowired
    private CourseServiceImp courseServiceImp;

    @RequestMapping("/createCourse")
    public String CreateCourse(String sumtime, String course_name,String author, Integer classid, String grade, @RequestParam("file") MultipartFile file) throws Exception {
        // 如果文件不为空，写入上传路径
        String newVidoeName = null;
        System.out.println("课程名称：" + course_name + "  课程种类：" + classid + "  课程等级:" + grade);
User user= (User) SecurityUtils.getSubject().getPrincipal();
        int u_id=0;
if (user!=null){
   u_id=user.getUser_id();
}
        try {
            if (!file.isEmpty()) {
                //获取文件后缀
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                        .toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                newVidoeName = pikId + "." + fileExt;
                //保存视频
                //        获取项目路径
                String property = System.getProperty("user.dir");
                String s1 = property.replaceAll("\\\\", "/");
                String s2 = "/src/main/resources/static/images/";
                String path = s1 + s2;
                System.out.println("文件保存路径：" + path);
                //创建文件路径
                // 判断路径是否存在，如果不存在就创建一个
                // 将上传文件保存到一个目标文件当中
                file.transferTo(new File(path + newVidoeName));
                System.out.println("文件名：" + newVidoeName);
            }
        } catch (IOException e) {
            System.out.println("上传失败");
        }
        Course course = new Course();
//    设置课程ID
        int pikId2 = 2019121300;
        int i = courseServiceImp.CountCourse();
        course.setC_chapter_id(pikId2 + i);
//    添加课程信息
        course.setCourse_name(course_name);
        course.setClass_id(classid);
        course.setGrade(grade);
        course.setImg(newVidoeName);
//    设置创建时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date.getTime());
        course.setCourse_date(time);
//    绑定用户ID
        course.setC_user_id(u_id);
        course.setSumtime(sumtime);
//        作者
        course.setAuthor(author);
//    操作数据库
        int a = courseServiceImp.InsertCourse(course);
        System.out.println(a);
        return "manage/table-basic";
    }
}
