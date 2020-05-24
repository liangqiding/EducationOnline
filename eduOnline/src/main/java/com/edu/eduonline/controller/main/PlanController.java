package com.edu.eduonline.controller.main;

import com.edu.eduonline.pojo.MyCourse;
import com.edu.eduonline.pojo.My_plan;
import com.edu.eduonline.service.imp.MyCourseServiceImp;
import com.edu.eduonline.service.imp.PlanServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/5 0005 16:34
 * @Description: TODO 播放进度
 */
@RestController
@RequestMapping("/vip")
public class PlanController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private PlanServiceImp planServiceImp;
    @Autowired
    private MyCourseServiceImp myCourseServiceImp;

    static private Set<My_plan> set = new HashSet<>();

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 生成进度表or保存进度
     * @Date 16:34 2020/3/5 0005
     * @Param
     **/
    @RequestMapping("/savePlan")
    public String savePlan(Integer cha_id, Integer percent, Integer course_id) {
//        判断登录状态
        int shiro_u_id = userServiceImp.getShiro_U_id();
        if (shiro_u_id == 0) {
            return "login";
        }
        My_plan my_plan1 = new My_plan();
        my_plan1.setP_plan(percent);
        my_plan1.setCourse_id(course_id);
        my_plan1.setU_id(shiro_u_id);
        my_plan1.setCha_id(cha_id);
        boolean contains = set.contains(my_plan1);
        if (contains) {
            return "重复执行";//不做任何操作
        }
        if (set.size() >= 10)
            set.clear();
        set.add(my_plan1);
//        记录用户足迹
        saveFootmake(shiro_u_id, course_id, cha_id, percent);
//        判断是否需要创建新的记录 否者直接修改原进度
        My_plan my_plan = judge(cha_id, shiro_u_id);
        if (my_plan == null) {
            int i = planServiceImp.InsertMyPlan(my_plan1);
//            更新记录
            return "成功";
        } else if (my_plan.getP_plan() < percent) {
            int i = planServiceImp.UpdateMy_planByCha_idAndU_id(my_plan1);
        }
        return "成功";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取上次播放进度 或者 plan==1  点击播放的记录进度
     * @Date 16:50 2020/3/5 0005
     * @Param
     **/
    @RequestMapping("/getPlan")
    public Integer getPlan(HttpSession session,Integer cha_id, Integer course_id) {
        int u_id = userServiceImp.getShiro_U_id();
        if (u_id == 0) {
            return 0;
        }
        Integer plan = (Integer) session.getAttribute("plan");
        session.removeAttribute("plan");
        if (plan!=null){
            My_plan my_plan = planServiceImp.SelPlanByCha_idAndU_id(cha_id, u_id);
            return my_plan.getP_plan();
        }
        MyCourse myCourse = new MyCourse();
        myCourse.setCourse_id(course_id);
        myCourse.setU_id(u_id);
        MyCourse myCourse1 = myCourseServiceImp.SelMyCourseByU_idAndCou_id(myCourse);
        if (myCourse1 == null) {
            return 0;
        }
        try {
            return myCourse1.getFootmark();
        } catch (Exception e) {
            return 0;
        }

    }
    @RequestMapping("/getPlan2")
    public Integer getPlan2(HttpSession session,Integer cha_id, Integer course_id) {
        int u_id = userServiceImp.getShiro_U_id();
        if (u_id == 0) {
            return 0;
        }
        Integer plan = (Integer) session.getAttribute("plan");
        session.removeAttribute("plan");
       try {
           My_plan my_plan = planServiceImp.SelPlanByCha_idAndU_id(cha_id, u_id);
           return my_plan.getP_plan();
       }catch (Exception e){
           return 0;
       }
    }

    //    判断是否需要新建行
    private My_plan judge(Integer cha_id, Integer u_id) {
        My_plan my_plan = planServiceImp.SelPlanByCha_idAndU_id(cha_id, u_id);
        if (my_plan != null) {
            return my_plan;
        } else
            return null;
    }

    //   保存用户上次播放进度
    private void saveFootmake(Integer u_id, Integer course_id, Integer cha_id, Integer percent) {
        MyCourse myCourse = new MyCourse();
        myCourse.setU_id(u_id);
        myCourse.setCourse_id(course_id);
        myCourse.setFootmark(percent);
        myCourse.setCha_id(cha_id);
        //    设置创建时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date.getTime());
        myCourse.setLast_date(time);
        int i = myCourseServiceImp.UpdateMyCourseByCourse_idAndUid(myCourse);
    }
}
