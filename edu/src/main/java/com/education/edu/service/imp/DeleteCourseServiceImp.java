package com.education.edu.service.imp;

import com.education.edu.service.DeleteCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 9:51
 * @descriptio
 */
@Service
public class DeleteCourseServiceImp implements DeleteCourseService {
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Override
    public int DeleteCourseAllBy(Integer c_chapter_id) {
//        删除子课程
        int i = chapterServiceImp.DeleteChapterByCourse_cha_id(c_chapter_id);
//        删除课程
        int i1 = courseServiceImp.DeleteCourseByCid(c_chapter_id);
        return i+i1;
    }
}
