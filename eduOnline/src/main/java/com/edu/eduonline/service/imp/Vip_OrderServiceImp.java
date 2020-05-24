package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.VipMapper;
import com.edu.eduonline.dao.Vip_OrderMapper;
import com.edu.eduonline.pojo.Vip;
import com.edu.eduonline.pojo.Vip_order;
import com.edu.eduonline.service.Vip_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/11 0011 16:00
 * @Description: TODO
 */
@Service
public class Vip_OrderServiceImp implements Vip_OrderService {
    @Autowired
private Vip_OrderMapper vip_orderMapper;
    @Override
    public int InsVip(Vip_order vip_order) {
        return vip_orderMapper.InsVip_Order(vip_order);
    }

    @Override
    public List<Vip_order> SelVipOrder(Vip_order vip_order) {
        return vip_orderMapper.SelVipOrder(vip_order);
    }

}
