package com.edu.eduonline.controller.main;

import com.edu.eduonline.pojo.User;
import com.edu.eduonline.pojo.Vip;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import com.edu.eduonline.service.imp.VipServiceImp;
import com.edu.eduonline.service.imp.Vip_OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/10 0010 13:35
 * @Description: TODO 顶部导航栏
 */
@RestController
@RequestMapping("/main")
public class HerderController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private VipServiceImp vipServiceImp;
    @Autowired
    private GetDateImp getDateImp;
    /**
     * @Author 梁其定
     * @Description //TODO 获取用户信息
     * @Date 13:36 2020/3/10 0010
     * @Param
     * @return
    **/
    @RequestMapping("/getUser")
    public User getUser() {
        int shiro_u_id = userServiceImp.getShiro_U_id();
        if (shiro_u_id<=0){
            return null;
        }
        User user = userServiceImp.SelUserByID(shiro_u_id);
        return user;
    }
    /**
     * @Author 梁其定
     * @Description //TODO 判断VIP身份
     * @Date 13:43 2020/3/16 0016
     * @Param
     * @return
    **/
    @RequestMapping("/getVip")
    public Long getVip() {
        Vip vip = vipServiceImp.SelVip(userServiceImp.getShiro_U_id());
        if (vip==null)
            return null;
        String nowDate = getDateImp.getDateFormatToLong();
//        判断开通日期到现在过去多久
        long last=Long.parseLong(nowDate) - Long.parseLong(vip.getStartdate());
//        判断是否过期
        long l = vip.getLongtime() - last;
        if (l>0){
            return l;
        }else
        return 0l;
    }
}
