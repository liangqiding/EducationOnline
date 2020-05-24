package com.edu.eduonline.controller.main.My;

import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.service.imp.CourseServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * @Author: 梁其定
 * @DateTime: 2020/3/18 0018 13:57
 * @Description: TODO
 */
@RestController
@RequestMapping("/vip")
public class MySubmitController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    /**
     * @Author 梁其定
     * @Description //TODO 获取我投稿的视频
     * @Date 16:37 2020/3/12 0012
     * @Param
     * @return
     **/
    @RequestMapping("/getMySubmit")
    public List<Course> getLike() {
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(1, 100, new Course().setU_id(userServiceImp.getShiro_U_id()));
        return pageInfo.getList();
    }
    /**
     * @Author 梁其定
     * @Description //TODD获取投稿总数
     * @Date 14:17 2020/3/18 0018
     * @Param
     * @return
    **/
    @RequestMapping("/getMySubmitSize")
    public Integer getMySubmitSize() {
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(1, 100, new Course().setU_id(userServiceImp.getShiro_U_id()));
        int size = pageInfo.getList().size();
        return size;
    }
    /**
     * @Author 梁其定
     * @Description //TODO 删除投稿的视频
     * @Date 16:38 2020/3/12 0012
     * @Param delLike
     * @return
     **/
    @RequestMapping("/delSubmit")
    public String delLike(Integer id) {
        return "移除失败！";
    }
}
