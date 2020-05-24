package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Vip_order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Vip_OrderMapper {
    int InsVip_Order(Vip_order vip_order);
    List<Vip_order> SelVipOrder(Vip_order vip_order);
}
