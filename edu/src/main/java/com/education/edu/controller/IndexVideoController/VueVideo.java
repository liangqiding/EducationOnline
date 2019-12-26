package com.education.edu.controller.IndexVideoController;

import com.education.edu.pojo.Chapter;
import com.education.edu.service.imp.ChapterServiceImp;
import com.education.edu.service.imp.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/12/012 15:53
 * @descriptio 视频资源
 */
@RestController
public class VueVideo {
    @Autowired
    private ChapterServiceImp chapterServiceImp;

    @RequestMapping("/AVideo")
    public Chapter AVideo(Integer cha_id, Integer c_chapter_id, HttpSession session) {

        if (cha_id != null) {
            Chapter chapters = chapterServiceImp.SelectChapterById(cha_id);
            System.out.println("切换视频：" + chapters);
            return chapters;
        }else if (c_chapter_id!=null) {
            System.out.println("默认视频:" + c_chapter_id);
            List<Chapter> chapters = chapterServiceImp.SelectChapterAllById(c_chapter_id);
            Chapter cha = new Chapter();
            for (Chapter c : chapters) {
                cha = c;
                break;
            }
            return cha;
        }
//        没有课程信息！
   return null;
    }
}
