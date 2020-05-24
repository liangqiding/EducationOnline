package com.edu.eduonline.controller.main;

import com.edu.eduonline.pojo.*;
import com.edu.eduonline.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/2/27 0027 16:36
 * @Description: TODO 负责 首页等模块网页跳转
 */
@Controller
@RequestMapping("/vip")
public class Main {

    @Autowired
    private MyCourseServiceImp myCourseServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private GetDateImp getDateImp;
    @Autowired
    private RateServiceImp rateServiceImp;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 跳转视频播放页面  ，新建课表，用作记录用户上次播放位置
     * @Date 16:05 2020/3/6 0006
     * @Param 传入课程ID
     **/
    @RequestMapping("/videos")
    public String video(HttpSession session, Integer course_id) {
        int u_id = userServiceImp.getShiro_U_id();
//        统计网站总播放量

        sum(course_id,u_id);
//        统计单个课程播放量
        sum2(course_id, u_id);

        session.setAttribute("main/course_id", course_id);
//判断是否需要创建
        MyCourse myCourse = new MyCourse().setCourse_id(course_id).setU_id(u_id);
        int i = myCourseServiceImp.SelMyCourseCount(myCourse);
        if (i > 0) {
            return "main/video";
        } else {
//            插入新行
            //    设置创建时间
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String time = sf.format(date.getTime());
            myCourse.setM_date(time);
            List<Chapter> chapters = chapterServiceImp.SelectChapterAllByCourse_id(course_id, userServiceImp.getShiro_U_id());
            try {
                Integer cha_id = chapters.iterator().next().getCha_id();
                myCourse.setCha_id(cha_id);
            } catch (Exception e) {
                return "main/video";
            }
            myCourseServiceImp.InsertMyCourse(myCourse);
        }
        return "main/video";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 投稿
     * @Date 16:28 2020/3/16 0016
     * @Param
     **/
    @RequestMapping("/submit1")
    public String submit() {
        return "main/submit/submit1";
    }
//    >>>>submit2-4 在SubmitController类

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 统计本月网站总播放量
     * @Date 16:03 2020/3/19 0019
     * @Param
     **/
    private void sum(Integer course_id, Integer u_id) {
        StaticMap.MapKey mapKey = new StaticMap.MapKey().setCourse_id(course_id).setU_id(u_id);
//        判断是否重复执行
        if (StaticMap.sumMap.containsKey(mapKey)) {
            Long aLong = StaticMap.sumMap.get(mapKey);
            long dateFormatSecond = getDateImp.getDateFormatSecond();
            if ((dateFormatSecond - aLong) < 600) {
                return;
            } else {//大于10分钟 重置
                StaticMap.sumMap.remove(mapKey);
            }
        }
        StaticMap.sumMap.put(mapKey, getDateImp.getDateFormatSecond());
        int dateFormatMouth = getDateImp.getDateFormatMouth();
        Rate rate = new Rate().setDate(dateFormatMouth).setSum(1);
        if (rateServiceImp.SelRate(dateFormatMouth) > 0) {
//             执行更新
            rateServiceImp.UdpRate(rate);
        } else {
//             执行插入
            rateServiceImp.InsRate(rate);
        }

    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 统计单个课程播放量
     * @Date 16:07 2020/3/19 0019
     * @Param
     **/
    public static int i = 0;

    private void sum2(Integer course_id, Integer u_id) {
        StaticMap.MapKey mapViewKey = new StaticMap.MapKey().setCourse_id(course_id).setU_id(u_id);
        if (!StaticMap.viewMap.containsKey(mapViewKey)) {
            StaticMap.viewMap.put(mapViewKey, getDateImp.getDateFormatToLong());
            courseServiceImp.UdpCourse(new Course().setCourse_id(course_id).setView(1));
        }
    }
}
