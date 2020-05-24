package com.edu.eduonline.controller.main.My;

import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/16 0016 16:17
 * @Description: TODO 投稿
 */
@Controller
@RequestMapping("/vip")
public class SubmitController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    @Autowired
    private GetDateImp getDateImp;
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    //    初始化map集合
    private static Map<Integer, String> hashMap = new HashMap<>();

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 跳转类
     * @Date 16:58 2020/3/17 0017
     * @Param
     **/
    @RequestMapping("/submit2")
    public String submit2() {
        int u_id = userServiceImp.getShiro_U_id();
        if (!hashMap.containsKey(u_id))
            return "main/submit/submit1";
        return "main/submit/submit2";
    }

    @RequestMapping("/submit3")
    public String submit3() {
        int u_id = userServiceImp.getShiro_U_id();
        if (!hashMap.containsKey(u_id))
            return "main/submit/submit1";
        return "main/submit/submit3";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 创建课程
     * @Date 16:58 2020/3/17 0017
     * @Param
     **/
    @RequestMapping("/createCourse2")
    public String CreateCourse(Course course, @RequestParam("file") MultipartFile file) throws Exception {
        // 如果文件不为空，写入上传路径
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String newVidoeName = null;
        int u_id = userServiceImp.getShiro_U_id();
        if (u_id == 0) {
            return "login/login";
        }
        if (hashMap.containsKey(u_id)){
            hashMap.replace(u_id, uuid);
        }

        else{
            hashMap.put(u_id, uuid);
        }

        if (!file.isEmpty()) {
            newVidoeName = saveFileServiceImp.saveImages_File(file, "course");
        }
        course.setImg(newVidoeName)
                .setCourse_date(getDateImp.getDate())
                .setU_id(u_id)
                .setState("待审核")
                .setUuid(uuid);
//    操作数据库
        try {
            courseServiceImp.InsertCourse(course);
            System.out.println("SuccessInsertDB>>>");
        } catch (Exception e) {
            e.printStackTrace();
            return "main/submit/submit1";
        }
        return "main/submit/submit2";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 添加章节视频
     * @Date 15:20 2020/3/17 0017
     * @Param
     **/
    @RequestMapping("/addChapter2")
    public String Add(Chapter chapter, MultipartFile file, MultipartFile file2) throws Exception {
        int u_id = userServiceImp.getShiro_U_id();
        if (!hashMap.containsKey(u_id)) {
            return "main/submit/submit1";
        }
        String uuid = hashMap.get(u_id);
        Course course = courseServiceImp.SelCourseByUUID(uuid);
        // 如果文件不为空，写入上传路径
        String VideoName = saveFileServiceImp.saveVideo_File(file, chapter.getCourse_id());
        String ImageName = saveFileServiceImp.saveImages_File(file2, "chapter");
        String date = getDateImp.getDate();
        chapter.setCha_date(date).setImages(ImageName).setVideo(VideoName).setCourse_id(course.getCourse_id());
//        操作数据库
        try {
            chapterServiceImp.InsertChapter(chapter);
            return "main/submit/submit3";
        } catch (Exception e) {
            return "main/submit/submit2";
        }
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 预览+F发布课程
     * @Date 16:36 2020/3/17 0017
     * @Param
     **/
    @RequestMapping("/udpChapter2")
    public String udpChapter2(Course course, @RequestParam("file") MultipartFile file) throws Exception {
        int u_id = userServiceImp.getShiro_U_id();
        System.out.println(hashMap.get(u_id));
        if (!hashMap.containsKey(u_id)){
            return "main/submit/submit1";
        }

        hashMap.remove(u_id);
        String newVidoeName = null;
        if (u_id == 0) {
            return "login/login";
        }
        if (!file.isEmpty()) {
            newVidoeName = saveFileServiceImp.saveImages_File(file, "course");
            saveFileServiceImp.deleteImages_File("course",course.getImg());
        }
        course.setImg(newVidoeName)
                .setCourse_date(getDateImp.getDate())
                .setU_id(u_id)
                .setState("待审核");

//    操作数据库
        try {
            courseServiceImp.UdpCourse(course);
            System.out.println("SuccessInsertDB>>>");
        } catch (Exception e) {
            e.printStackTrace();
            return "main/submit/submit4";
        }
        return "main/submit/submit4";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取预览课程
     * @Date 16:13 2020/3/17 0017
     * @Param
     **/
    @RequestMapping("/getCourseSubmit")
    @ResponseBody
    public Course getCourseSubmit() {
        int u_id = userServiceImp.getShiro_U_id();
        if (!hashMap.containsKey(u_id)) {
            return null;
        }
        String uuid = hashMap.get(u_id);
        Course course = courseServiceImp.SelCourseByUUID(uuid);
        return course;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 释放map空间
     * @Date 16:54 2020/3/17 0017
     * @Param
     **/
    @RequestMapping("/submit4")
    public String submit4() {
        int u_id = userServiceImp.getShiro_U_id();
        if (hashMap.containsKey(u_id)) {
            hashMap.remove(u_id);
            return "main/submit/submit4";
        }
        return "main/submit/submit1";
    }
}
