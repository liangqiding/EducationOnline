package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.CourseMapper;
import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/2/28 0028 14:43
 * @Description: TODO 
 */
@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public PageInfo<Course> SelCourse(Integer pageNum,Integer pageSize,Course course) {
        PageHelper.startPage(pageNum,pageSize);
        List<Course> courses = courseMapper.SelCourse(course);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        return pageInfo;
    }

    @Override
    public int InsertCourse(Course course) {
        return courseMapper.InsertCourse(course);
    }

    @Override
    public int DeleteCourseByCourse_id(Course course) {
        return courseMapper.DeleteCourseByCourse_id(course);
    }

    @Override
    public int UdpCourse(Course course) {
        return courseMapper.UdpCourse(course);
    }

    @Override
    public Course SelCourseById(Integer course_id) {
        return courseMapper.SelCourseById(course_id);
    }

    @Override
    public Course SelCourseByUUID(String uuid) {
        return courseMapper.SelCourseByUUID(uuid);
    }

    @Override
    public List<Course> SelCourseToSub(Integer my_id) {
        return courseMapper.SelCourseToSub(my_id);
    }
}
