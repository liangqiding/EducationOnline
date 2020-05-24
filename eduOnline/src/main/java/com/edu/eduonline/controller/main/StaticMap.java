package com.edu.eduonline.controller.main;

import com.edu.eduonline.service.imp.UserServiceImp;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/19 0019 10:46
 * @Description: TODO 播放量计算
 */
@Component
public class StaticMap {
    @Autowired
    private UserServiceImp userServiceImp;
    //    播放量
    public static Map<MapKey, String> viewMap = new HashMap<>();
    //    点赞
    public static Map<MapKey, String> goodMap = new HashMap<>();
    //    网页总播放流量统计
    public static Map<MapKey, Long> sumMap = new HashMap<>();
    // 暂存vip
    public static Map<Integer, String> vipMap = new HashMap<>();
    @Accessors(chain = true)
    @Data
    @ToString
    static
    class MapKey {
        private Integer u_id;
        private Integer course_id;
    }
    //    public void contextInitialized(ServletContextEvent arg0) {
//        // 服务启动、初始化时执行------60分钟一次
//        int minutes = 60;
//        int second = 60;
//        int timeDistance = 1000;
//        // 使用定时类，每隔一段时间执行
//        java.util.Timer timer = new java.util.Timer();
//        timer.schedule(new MyRandomMap(), new Date(), minutes * second * timeDistance);
//    }
//
//    private class MyRandomMap extends java.util.TimerTask // 实现了TimerTask的类
//    {
//        public void run() {
//            // 每隔一段时间执行
//            System.out.println("start++++++++++");
//        }
//    }

}
