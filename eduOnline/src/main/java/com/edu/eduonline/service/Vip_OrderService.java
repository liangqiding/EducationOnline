package com.edu.eduonline.service;

import com.edu.eduonline.pojo.Vip;
import com.edu.eduonline.pojo.Vip_order;

import java.util.List;

public interface Vip_OrderService {
    int InsVip(Vip_order vip_order);
    List<Vip_order> SelVipOrder(Vip_order vip_order);

}
