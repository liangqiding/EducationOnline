package com.edu.eduonline.controller.manage.Chapter;

import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/2 0002 16:47
 * @Description: TODO 章节详情页
 */
@RestController
@RequestMapping("/manage")
public class Table_chapterController {
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取章节列表
     * @Date 14:03 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/GetChapterByCourse_id")
    public List<Chapter> GetChapterList(HttpSession session) {
        Integer course_id = (Integer) session.getAttribute("course_id");
        List<Chapter> chapters = chapterServiceImp.SelChapterByCourse_id(course_id);
        return chapters;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取课程信息
     * @Date 14:03 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/GetCourse")
    public Course GetCourse_id(HttpSession session) {
        Integer course_id = (Integer) session.getAttribute("course_id");
        Course course = courseServiceImp.SelCourseById(course_id);
        return course;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 删除章节
     * @Date 14:37 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/del_chapter")
    public String del_chapter(Integer cha_id) {
        Chapter chapter = chapterServiceImp.SelectChapterByCha_Id(cha_id);
        saveFileServiceImp.deleteVideo_File( chapter.getVideo());
        saveFileServiceImp.deleteImages_File("chapter", chapter.getImages());
        int i = chapterServiceImp.DelChapter(cha_id);
        if (i > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 遍历出第一个章节的视频 或者通过ID查询出唯一一个视频
     * @Date 16:25 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/getVideo")
    public Chapter getVideo(HttpSession session, Integer cha_id) {
        Chapter list = new Chapter();
        if (cha_id != null) {
            list = chapterServiceImp.SelectChapterByCha_Id(cha_id);
        } else {
            Integer course_id = (Integer) session.getAttribute("course_id");
            List<Chapter> chapters = chapterServiceImp.SelChapterByCourse_id(course_id);
            for (Chapter c : chapters
            ) {
                list = c;
                break;
            }
        }
        //            保存用户操作缓存
        session.setAttribute("cha_id", list.getCha_id());
        return list;
    }
}
