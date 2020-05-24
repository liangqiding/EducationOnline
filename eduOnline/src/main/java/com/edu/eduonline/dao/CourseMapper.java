package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
//    查询课程
    List<Course> SelCourse(Course course);
//    添加课程
    int InsertCourse(Course course);
//    删除课程
    int DeleteCourseByCourse_id(Course course);
//    更新课程
    int UdpCourse(Course course);
//    通过ID 查找课程
    Course  SelCourseById(@Param(value = "course_id") Integer course_id);
    Course SelCourseByUUID(String uuid);
    List<Course> SelCourseToSub(@Param("my_id")Integer my_id);
}
