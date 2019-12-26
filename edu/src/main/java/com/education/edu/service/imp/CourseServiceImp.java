package com.education.edu.service.imp;

import com.education.edu.dao.CourseMapper;
import com.education.edu.pojo.Course;
import com.education.edu.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 课程业务层
 */
@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageInfo<Course> SelectCourse(String course_name,Integer Num,Integer Size)
    {
        PageHelper.startPage(Num,Size);
        List<Course> courses = courseMapper.SelectCourse(course_name);
        PageInfo<Course> pageInfo=new PageInfo<>(courses);
        return pageInfo;
    }

    @Override
    public int InsertCourse(Course course) {
        return courseMapper.InsertCourse(course);
    }

    @Override
    public int CountCourse() {
        return courseMapper.CountCourse();
    }

    @Override
    public List<Course> SelectAllCourseByUserId(Integer c_user_id) {
        return courseMapper.SelectAllCourseByUserId(c_user_id);
    }

    @Override
    public int DeleteCourseByCid(Integer c_chapter_id) {
        return courseMapper.DeleteCourseByCid(c_chapter_id);
    }

    @Override
    public Course SelectCourseByC_chapter_id(Integer c_chapter_id) {
        return courseMapper.SelectCourseByC_chapter_id(c_chapter_id);
    }
}
