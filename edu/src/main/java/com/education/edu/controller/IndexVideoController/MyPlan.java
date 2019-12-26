package com.education.edu.controller.IndexVideoController;

import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.My_plan;
import com.education.edu.pojo.Mycourse;
import com.education.edu.pojo.User;
import com.education.edu.service.imp.ChapterServiceImp;
import com.education.edu.service.imp.My_planServiceImp;
import com.education.edu.service.imp.MycourseServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/18/018 8:50
 * @descriptio 我的章节学习记录
 */
@Controller
public class MyPlan {
    @Autowired
    private My_planServiceImp my_planServiceImp;
    @Autowired
    private MycourseServiceImp mycourseServiceImp;
    @Autowired
    private ChapterServiceImp chapterServiceImp;

    @RequestMapping("/plan")
    @ResponseBody
    public String course(Integer cha_id, Integer percent, Integer course_cha_id) {

//        更新播放进度
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        My_plan my_plan2 = my_planServiceImp.SelectMyPlanByCha_id(cha_id, user.getUser_id());
        if (my_plan2 != null && my_plan2.getP_plan() >= percent) {
            return "不需要保存";
        } else if (my_plan2 == null) {
            return "";
        }
        System.out.println("播放进度：" + percent + "% 课程ID为：" + cha_id);
        My_plan my_plan = new My_plan();
        my_plan.setP_plan(percent);
        my_plan.setP_cha_id(cha_id);
        my_plan.setU_id(user.getUser_id());
//        开始保存章节进度
        my_planServiceImp.UpdateMy_planByCha_id(my_plan);
//         保存总进度
        Mycourse mycourse = new Mycourse();
        mycourse.setU_id(user.getUser_id());
        mycourse.setC_chapter_id(course_cha_id);
        //查询我的课程及其章节进度
        List<Chapter> chapters = chapterServiceImp.SelectChapterAndMy_Plan(user.getUser_id(), course_cha_id);
        int i = 0, cout = 0;
        for (Chapter c : chapters
        ) {
//            获取单个章节进度
            cout += c.getP_plan();
            i += 100;
        }
//设置总进度 sump=count(单个章节进度)/i
        int sump = cout*100 / i;
        mycourse.setM_plan(sump);
        mycourseServiceImp.UpdateMycourseByC_course_idAndUid(mycourse);

        return "成功";
    }

    //    从数据库获取学习进度 跳转播放
    @RequestMapping("/getPlan")
    @ResponseBody
    public Integer Test(Integer cha_id) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        My_plan my_plan2 = my_planServiceImp.SelectMyPlanByCha_id(cha_id, user.getUser_id());
        if (my_plan2 != null) {
            return my_plan2.getP_plan();
        }
        return 0;
    }
}
