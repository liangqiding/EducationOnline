package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VipMapper {
    int InsVip(Vip vip);
    Vip SelVip(@Param("u_id") Integer u_id);
    int UdpVipByU_id(Vip vip);
}
