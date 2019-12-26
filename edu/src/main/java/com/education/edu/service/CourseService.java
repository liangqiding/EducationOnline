package com.education.edu.service;

import com.education.edu.pojo.Course;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 课程业务接口
 */
public interface CourseService {
    PageInfo<Course> SelectCourse(String course_name,Integer Num, Integer Size);

    //    添加课程
    int InsertCourse(Course course);

    //    统计课程数量
    int CountCourse();

    //    查询课程信息
    List<Course> SelectAllCourseByUserId(Integer c_user_id);

    //    删除课程
    int DeleteCourseByCid(Integer c_chapter_id);

    //    查询课程
    Course SelectCourseByC_chapter_id(Integer c_chapter_id);
}
