package com.edu.eduonline.controller.manage;

import com.edu.eduonline.pojo.Rate;
import com.edu.eduonline.service.imp.RateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/19 0019 16:59
 * @Description: TODO
 */
@RestController
@RequestMapping("/vip")
public class RateController {
    @Autowired
    private RateServiceImp rateServiceImp;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取统计
     * @Date 17:00 2020/3/19 0019
     * @Param
     **/
    @RequestMapping("/getRate")
    public List<Rate> getRate() {
        List<Rate> rates = rateServiceImp.SelRateAll();
        List<Rate> collect = rates.stream().sorted(Comparator.comparing(Rate::getId).reversed()).limit(6).collect(Collectors.toList());
//        List<Rate> collect = rates.stream().sorted(Comparator.comparing(Rate::getId).reversed()).limit(6).collect(Collectors.toList());
        int sum = collect.stream().mapToInt(Rate::getSum).sum();
//        计算平均水平
        int i = sum / collect.size();
        ArrayList<Rate> objects = new ArrayList<>();
        for (Rate r : collect
        ) {
            r.setPlan(i);
            objects.add(r);
        }
        System.out.println(objects);
        return objects;
    }
}
