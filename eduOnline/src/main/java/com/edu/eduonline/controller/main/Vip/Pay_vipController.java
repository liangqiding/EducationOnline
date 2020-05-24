package com.edu.eduonline.controller.main.Vip;

import com.edu.eduonline.controller.main.StaticMap;
import com.edu.eduonline.pojo.Vip;
import com.edu.eduonline.pojo.Vip_order;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import com.edu.eduonline.service.imp.VipServiceImp;
import com.edu.eduonline.service.imp.Vip_OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/11 0011 15:12
 * @Description: TODO 支付
 */
@Controller
@RequestMapping("/vip")
public class Pay_vipController {
    @Autowired
    private VipServiceImp vipServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private GetDateImp getDateImp;
    @Autowired
    private Vip_OrderServiceImp vip_orderServiceImp;
    static Set<String> set = new HashSet<>();

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 模拟支付
     * @Date 15:48 2020/3/11 0011
     * @Param
     **/
    @RequestMapping("/pay")
    public String pay(Double price, Model model, HttpSession session) {
        String uuid = (String) session.getAttribute("uuid");
        if (set.contains(uuid)) {
            model.addAttribute("msg", "重复操作，无效的支付");
            return "/main/vip/pay_vip3";
        }
        boolean add = set.add(uuid);
        if (set.size() > 10000) {
            set.clear();
        }
        int shiro_u_id = userServiceImp.getShiro_U_id();
        if (shiro_u_id == 0) {
            return "login";
        }
        String year = null;
        long longtime = 0L;
        if (price >= 98) {
            year = "年费VIP";
            longtime = 365;
        } else if (price >= 32) {
            year = "VIP";
            longtime = 90;
        } else if (price >= 12) {
            year = "VIP";
            longtime = 30;
        }
//        获取开通日期
        String date = getDateImp.getDateFormatToLong();
//        生成订单
        Vip_order vip_order = new Vip_order()
                .setU_id(shiro_u_id)
                .setDate(date)
                .setLongtime(longtime)
                .setPrice(price)
                .setOrder_id(UUID.randomUUID().toString().replaceAll("-", ""));
//        操作数据库01
        vip_orderServiceImp.InsVip(vip_order);
//        生成vip表
        Vip vip = new Vip().setGrade("VIP").setLongtime(longtime).setStartdate(date).setU_id(shiro_u_id).setYear(year);
        int i=0;
//        生成vip表
        if (getVips(shiro_u_id)==1){
           i = vipServiceImp.InsVip(vip);
        }else if (getVips(shiro_u_id)==2){
           i = vipServiceImp.UdpVipByU_id(vip);
        }else {
            Vip vip2 = new Vip().setGrade("VIP").setLongtime(longtime+getVips(shiro_u_id)).setStartdate(date).setU_id(shiro_u_id).setYear(year);
            i = vipServiceImp.UdpVipByU_id(vip2);
        }
        if (i > 0) {
            model.addAttribute("msg", "支付成功");
            if (StaticMap.vipMap.containsKey(shiro_u_id)){
                StaticMap.vipMap.remove(shiro_u_id);
            }
        } else {
            model.addAttribute("msg", "支付失败");
        }
        return "/main/vip/pay_vip3";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 判断用户是否为首冲
     * @Date 14:36 2020/3/16 0016
     * @Param
     **/
    private long getVips(Integer u_id) {
        Vip vip = vipServiceImp.SelVip(u_id);
        if (vip == null) {//为首冲
            return 1;
        } else {
            String nowDate = getDateImp.getDateFormatToLong();
//        判断开通日期到现在过去多久
            long last = Long.parseLong(nowDate) - Long.parseLong(vip.getStartdate());
//        判断是否过期
            if ((vip.getLongtime() - last) <= 0) {//非首冲 已过期
                return 2;
            }else
                return vip.getLongtime() - last;
        }
        //非首冲 未过期

    }
}
