package com.edu.eduonline.controller.main;

import com.edu.eduonline.pojo.Subscribe;
import com.edu.eduonline.service.imp.SubscribeServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/3/21/021 11:11
 * @descriptio
 */
@RestController
@RequestMapping("/vip")
public class SubscribeController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private SubscribeServiceImp subscribeServiceImp;

    //关注
    @RequestMapping("/toSub")
    public String toSub(Integer u_id) {
        int my_id = userServiceImp.getShiro_U_id();
        int i1 = subscribeServiceImp.SelSubCountByMyAndHe(my_id, u_id);
        if (i1 > 0) {
            return "重复关注";
        }
        try {
            int i = subscribeServiceImp.InsSub(new Subscribe().setMy_id(my_id).setU_id(u_id));
            if (i > 0) {
                return "关注成功";
            }
        } catch (Exception e) {
            return "关注失败";
        }
        return "关注失败";
    }

    //    获取关注的列表
    @RequestMapping("/getSub")
    public List<Subscribe> Test() {
        List<Subscribe> subscribe = subscribeServiceImp.SelSubAndUser(userServiceImp.getShiro_U_id());
        return subscribe;
    }


    //    取消关注
    @RequestMapping("/delSub")
    public String delSub(Integer s_id) {

        try {
            int i = subscribeServiceImp.DelSub(s_id);
            if (i>0){
                return "取消成功！";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}