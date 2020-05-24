package com.edu.eduonline.service;

import com.edu.eduonline.pojo.Course;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
//    课程获取
    PageInfo<Course> SelCourse(Integer pageNum, Integer pageSize, Course course);
//    课程添加
    int InsertCourse(Course course);
//    课程删除
    int DeleteCourseByCourse_id(Course course);
//    课程更新
    int UdpCourse(Course course);
    Course  SelCourseById(@Param(value = "course_id") Integer course_id);
    Course SelCourseByUUID(String uuid);
    List<Course> SelCourseToSub(@Param("my_id")Integer my_id);
}
