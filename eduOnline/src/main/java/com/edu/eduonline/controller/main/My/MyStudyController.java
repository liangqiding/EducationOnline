package com.edu.eduonline.controller.main.My;

import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.Like;
import com.edu.eduonline.pojo.My_plan;
import com.edu.eduonline.pojo.Percent;
import com.edu.eduonline.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/13 0013 14:33
 * @Description: TODO 学习观看进度分析
 */
@RestController
@RequestMapping("/vip")
public class MyStudyController {
    @Autowired
    private PlanServiceImp planServiceImp;
    @Autowired
    private LikeServiceImp likeServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;
    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 通过用户ID获取收藏列表  获取课表 统计进度
     * @Date 14:35 2020/3/13 0013
     * @Param
     **/
    @RequestMapping("/getStudy")
    public List<Percent> getStudy() {
        List<Like> likes = likeServiceImp.SelLikeAll(userServiceImp.getShiro_U_id());
        if (likes.size()==0){
            return null;
        }
        List<Percent> p = new ArrayList<Percent>();
        int j=0;
        for (Like l :
                likes) {
            j++;
//            获取个人学习进度表
            List<My_plan> my_plans = planServiceImp.SelPlanByCour_idAndU_id(l.getCourse_id(), userServiceImp.getShiro_U_id());

            Course course = courseServiceImp.SelCourseById(l.getCourse_id());
            if (course.getCourse_id()==null){
                break;
            }
//            假如用户没有学习过
            if (my_plans.size()==0){
                p.add(new Percent().setPlan(0).setName(course.getCourse_name()).setCourse_id(course.getCourse_id()));
            }else {
//                求单个课程学习百分比
                int sumMy_plan = my_plans.stream().mapToInt(My_plan::getP_plan).sum();
                System.out.println(sumMy_plan);
//            获取课程总章节数
                int size = chapterServiceImp.SelChapterByCourse_id(l.getCourse_id()).size();
//            计算学习进度百分比
                int i = sumMy_plan / size;
                            p.add(new Percent().setPlan(i).setName(course.getCourse_name()).setCourse_id(course.getCourse_id()));
            }
        }
        System.out.println("Percent>>>:"+p+",次数"+j);
        return p;
    }
}
