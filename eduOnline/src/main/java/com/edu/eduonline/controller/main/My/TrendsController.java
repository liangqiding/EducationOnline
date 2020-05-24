package com.edu.eduonline.controller.main.My;

import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.service.imp.CourseServiceImp;
import com.edu.eduonline.service.imp.SubscribeServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/3/21/021 14:06
 * @descriptio
 */
@RestController
@RequestMapping("/vip")
public class TrendsController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private SubscribeServiceImp subscribeServiceImp;

    //获取关注的人的动态
    @RequestMapping("/getTrends")
    public List<Course> getTrends() {
        List<Course> courses = courseServiceImp.SelCourseToSub(userServiceImp.getShiro_U_id());
        List<Course> collect = courses.stream().sorted(Comparator.comparing(Course::getCourse_id).reversed()).collect(Collectors.toList());
        return collect;
    }
}
