package com.edu.eduonline.controller.main.Vip;

import com.edu.eduonline.pojo.Vip;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import com.edu.eduonline.service.imp.VipServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/16 0016 15:03
 * @Description: TODO 个人信息
 */
@RestController
@RequestMapping("/vip")
public class PersonalController {
    @Autowired
    private VipServiceImp vipServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private GetDateImp getDateImp;
    /**
     * @Author 梁其定
     * @Description //TODO 获取vip信息
     * @Date 15:06 2020/3/16 0016
     * @Param
     * @return
    **/
    @RequestMapping("/getVipList")
    public Vip getVipList() {
        int shiro_u_id = userServiceImp.getShiro_U_id();
        Vip vip = vipServiceImp.SelVip(shiro_u_id);
        if (vip==null){
            return null;
        }
        String nowDate = getDateImp.getDateFormatToLong();
//        判断开通日期到现在过去多久
        long last = Long.parseLong(nowDate) - Long.parseLong(vip.getStartdate());
//        计算vip剩余时长
        long l = vip.getLongtime() - last;
        vip.setLongtime(l);
        return vip;
    }
}
