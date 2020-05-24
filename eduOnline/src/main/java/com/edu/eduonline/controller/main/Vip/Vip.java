package com.edu.eduonline.controller.main.Vip;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/11 0011 14:33
 * @Description: TODO 开通vip
 */
@Controller
@RequestMapping("/vip")
public class Vip {
    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 跳转VIP开通页面
     * @Date 15:03 2020/3/11 0011
     * @Param
     **/
    @RequestMapping("/pay_vip")
    public String pay_vip() {
        return "main/vip/pay_vip";
    }
    //    扫码支付
    @RequestMapping("/pay_vip2")
    public String pay_vip2(double pay, Model model, HttpSession session)
    {
        session.setAttribute("uuid",UUID.randomUUID().toString().replaceAll("-",""));
        model.addAttribute("msg","总需支付："+pay+"元");
        model.addAttribute("price",pay);
        return "main/vip/pay_vip2";
    }

    //    支付结果
    @RequestMapping("/pay_vip3")
    public String pay_vip3() {
        return "main/vip/pay_vip3";
    }

    //    Vip主页
    @RequestMapping("/vip")
    public String vip() {
        return "main/vip/vip";
    }
}
