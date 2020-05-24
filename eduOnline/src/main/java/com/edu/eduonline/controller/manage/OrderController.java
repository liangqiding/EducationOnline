package com.edu.eduonline.controller.manage;

import com.edu.eduonline.pojo.Vip_order;
import com.edu.eduonline.service.imp.Vip_OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/18 0018 16:58
 * @Description: TODO
 */
@RestController
@RequestMapping("/manage")
public class OrderController {
    @Autowired 
    private Vip_OrderServiceImp vip_orderServiceImp;
    /**
     * @Author 梁其定
     * @Description //TODO 获取订单
     * @Date 17:00 2020/3/18 0018
     * @Param 
     * @return 
    **/
    @RequestMapping("/GetOrder")
    public List<Vip_order> GetOrder() {
        List<Vip_order>  vip_order = vip_orderServiceImp.SelVipOrder(null);
        List<Vip_order> collect = vip_order.stream().sorted(Comparator.comparing(Vip_order::getId).reversed()).collect(Collectors.toList());
        return collect;
    }
}
