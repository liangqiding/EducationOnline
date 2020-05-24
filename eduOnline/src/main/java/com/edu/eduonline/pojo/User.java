package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 用户
 */
@Accessors(chain = true)
@Data
@ToString
public class User {
    private Integer u_id;
    private String user_name;
    private String password;
    private String username;
    private Integer r_id;

    //    新加
    private String email;
//    专业
    private String major;
    private String date;
//    介绍
    private String introduce;
    private Integer age;
    private String sex;
//    头像
    private String images;

    private Integer v_id;
    //    开始日期
    private String startdate;
    //    总时长
    private long longtime;
    //    用户ID
    //    VIP等级
    private String grade;
    private String year;
}
