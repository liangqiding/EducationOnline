package com.edu.eduonline.controller.manage.Course;

import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.*;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/2/29 0029 16:29
 * @Description: TODO get教学视频数据
 */
@RestController
@RequestMapping("/manage")
public class TableController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 管理员获取课程信息
     * @Date 14:18 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/GetCourseByAdmin")
    public List<Course> Test() {
        Course course = new Course();
//        判断非登录状态操作
        int u_id = userServiceImp.getShiro_U_id();
        if (u_id <= 0) {
            return null;
        }
        if(u_id!=1){
            course.setU_id(u_id);
        }
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(1, 100, course);
        List<Course> list = pageInfo.getList();
//        按照id先后顺序，逆序排序
        List<Course> collect = list.stream().sorted(Comparator.comparing(Course::getCourse_id).reversed()).collect(Collectors.toList());
        return collect;
    }
    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 普通用户获取课程信息
     * @Date 14:18 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/GetCourseByUser")
    public List<Course> GetCourseByUser() {
        Course course = new Course();
//        判断非登录状态操作
        int u_id = userServiceImp.getShiro_U_id();
        if (u_id <= 0) {
            return null;
        }
            course.setU_id(u_id);
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(1, 100, course);
        List<Course> list = pageInfo.getList();
//        按照id先后顺序，逆序排序
        List<Course> collect = list.stream().sorted(Comparator.comparing(Course::getCourse_id).reversed()).collect(Collectors.toList());
        return collect;
    }
    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 更新课程
     * @Date 14:17 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/UpdateCourse")
    public String UpdateCourse() {
        Course course = new Course();
        int i = courseServiceImp.UdpCourse(course);
        return null;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 删除课程
     * @Date 14:17 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/DelCourse")
    public String del_chapter(@RequestParam(value = "course_id", defaultValue = "0") Integer course_id) {
//        循环删除所有章节 及其视频
        List<Chapter> chapters = chapterServiceImp.SelChapterByCourse_id(course_id);
        Course course1 = courseServiceImp.SelCourseById(course_id);
        saveFileServiceImp.deleteImages_File("course",course1.getImg());

//        删除数据库中所以章节
        chapters.stream().forEach(chapter -> chapterServiceImp.DelChapter(chapter.getCha_id()));
//删除所以本地文件
        try {
            chapters.stream().forEach(chapter2 -> saveFileServiceImp.deleteVideo_File( chapter2.getVideo()));
        } catch (Exception e) {
            System.out.println("视频：课程ID>>>" + course_id + " >>>删除失败");
        }
        try {
            chapters.stream().forEach(chapter2 -> saveFileServiceImp.deleteImages_File("chapter", chapter2.getImages()));
        } catch (Exception e) {
            System.out.println("封面：课程ID=" + course_id
                    + " >>>删除失败");
        }
        Course course = new Course();
        course.setCourse_id(course_id);
        int i = courseServiceImp.DeleteCourseByCourse_id(course);
        if (i > 0) {
            return "删除成功";
        }
        return "删除失败";
    }


}
