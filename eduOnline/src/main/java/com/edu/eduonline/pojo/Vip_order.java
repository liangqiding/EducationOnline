package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/11 0011 15:54
 * @Description: TODO 订单表
 */
@Accessors(chain = true)
@Data
@ToString
public class Vip_order {
    private Integer id;
    private String order_id;
    private Integer u_id;
    private String date;
    private long longtime;
    private double price;


//    >>>绑定用户表
    private String user_name;
    private String password;
    private String username;
    private Integer r_id;

    //    新加
    private String email;
    //    专业
    private String major;
    //    介绍
    private String introduce;
    private Integer age;
    private String sex;
}
