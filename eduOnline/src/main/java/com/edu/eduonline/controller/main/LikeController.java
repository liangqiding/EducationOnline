package com.edu.eduonline.controller.main;

import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.Like;
import com.edu.eduonline.service.imp.CourseServiceImp;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.LikeServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/6 0006 15:12
 * @Description: TODO 收藏课程
 */
@RestController
@RequestMapping("/vip")
public class LikeController {
    @Autowired
    private LikeServiceImp likeServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private GetDateImp getDateImp;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 收藏
     * @Date 11:19 2020/3/19 0019
     * @Param
     **/
    @RequestMapping("/toLike")
    public String toLike(Integer course_id) {
        Like like = new Like();
        like.setCourse_id(course_id);
        like.setU_id(userServiceImp.getShiro_U_id());
        int i1 = likeServiceImp.SelLikeCount(like);
        if (i1 > 0) {
            return "已在收藏夹中";
        }
        int i = likeServiceImp.InsLike(like);
        int i2 = courseServiceImp.UdpCourse(new Course().setCourse_id(course_id).setLike(1));
        if (i > 0) {
            return "收藏成功";
        }
        return "收藏失败";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 点赞
     * @Date 11:19 2020/3/19 0019
     * @Param
     */
    @RequestMapping("/toGood")
    public String toGood(Integer course_id) {
        int u_id = userServiceImp.getShiro_U_id();
        StaticMap.MapKey mapViewKey = new StaticMap.MapKey().setU_id(u_id).setCourse_id(course_id);
        if (!StaticMap.goodMap.containsKey(mapViewKey)) {
            courseServiceImp.UdpCourse(new Course().setGood(1).setCourse_id(course_id));
            StaticMap.goodMap.put(mapViewKey,getDateImp.getDateFormatToLong());
        }
        return null;
    }
}
