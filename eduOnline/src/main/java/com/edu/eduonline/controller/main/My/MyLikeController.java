package com.edu.eduonline.controller.main.My;

import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.Like;
import com.edu.eduonline.service.imp.LikeServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/12 0012 16:13
 * @Description: TODO
 */
@RestController
@RequestMapping("/vip")
public class MyLikeController {
    @Autowired
    private LikeServiceImp likeServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    /**
     * @Author 梁其定
     * @Description //TODO 获取收藏的视频
     * @Date 16:37 2020/3/12 0012
     * @Param
     * @return
    **/
    @RequestMapping("/getLike")
    public List<Like> getLike() {
        List<Like> like = likeServiceImp.SelLikeAll(userServiceImp.getShiro_U_id());
        return like;
    }
    /**
     * @Author 梁其定
     * @Description //TODO 删除收藏的视频
     * @Date 16:38 2020/3/12 0012
     * @Param delLike
     * @return
    **/
    /**
     * @Author 梁其定
     * @Description //TODD获取收藏总数
     * @Date 14:17 2020/3/18 0018
     * @Param
     * @return
     **/
    @RequestMapping("/getMyLikeSize")
    public Integer getMySubmitSize() {
        List<Like> like = likeServiceImp.SelLikeAll(userServiceImp.getShiro_U_id());
        int size = like.size();
        return size;
    }
    @RequestMapping("/delLike")
    public String delLike(Integer id) {
        int i = likeServiceImp.DelLike(id);
        if (i>0){
            return "移除成功！";
        }
        return "移除失败！";
    }
}
