package com.edu.eduonline.service;

import com.edu.eduonline.pojo.Vip;
import org.apache.ibatis.annotations.Param;

public interface VipService {
    int InsVip(Vip vip);
    Vip SelVip(@Param("u_id") Integer u_id);
    int UdpVipByU_id(Vip vip);
    boolean booleanVip();

}
