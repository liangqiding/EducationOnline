package com.edu.eduonline.service.imp;

import com.edu.eduonline.controller.main.StaticMap;
import com.edu.eduonline.dao.VipMapper;
import com.edu.eduonline.pojo.Vip;
import com.edu.eduonline.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/11 0011 14:32
 * @Description: TODO
 */
@Service
public class VipServiceImp implements VipService {
    @Autowired
    private VipMapper vipMapper;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private GetDateImp getDateImp;

    @Override
    public int InsVip(Vip vip) {
        return vipMapper.InsVip(vip);
    }

    @Override
    public Vip SelVip(Integer u_id) {
        return vipMapper.SelVip(u_id);
    }

    @Override
    public int UdpVipByU_id(Vip vip) {
        return vipMapper.UdpVipByU_id(vip);
    }

    /**
     * @Author 梁其定
     * @Description //TODO 判断VIP身份
     * @Date 10:57 2020/3/20 0020
     * @Param
     * @return
    **/
    @Override
    public boolean booleanVip() {
        int shiro_u_id = userServiceImp.getShiro_U_id();
        Vip vip = vipMapper.SelVip(shiro_u_id);
        if (vip != null) {
            long longtime = vip.getLongtime();
            String startdate = vip.getStartdate();
            String nowDate = getDateImp.getDateFormatToLong();
            long startdateL = Long.parseLong(startdate);
            long nowDateL = Long.parseLong(nowDate);
            long l = nowDateL - startdateL;
            if (longtime-l > 0) {
                return true;
            }
        }
        return false;

    }
}
