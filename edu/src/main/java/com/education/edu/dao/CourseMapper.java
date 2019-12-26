package com.education.edu.dao;

import com.education.edu.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 课程
 */
@Mapper
public interface CourseMapper {
    List<Course> SelectCourse(@Param("course_name") String course_name);

    //    添加图书
    int InsertCourse(Course course);

    //    统计课程数量
    int CountCourse();

    //    查询课程
    List<Course> SelectAllCourseByUserId(@Param(value="c_user_id")Integer c_user_id);

    //    删除课程
    int DeleteCourseByCid(Integer c_chapter_id);
//    查询课程
    Course SelectCourseByC_chapter_id(Integer c_chapter_id);
}
