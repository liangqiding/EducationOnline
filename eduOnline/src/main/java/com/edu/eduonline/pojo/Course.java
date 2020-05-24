package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 课程
 */
@Accessors(chain = true)
@Data
@ToString
public class Course extends User{
    //    课程id>>>主键
    private Integer course_id;
    //    课程名
    private String course_name;
    //    课程封面
    private String img;
    //    课程类别id
    private Integer class_id;
    //    课程级别
    private String grade;

    //    课程创建日期
    private String course_date;
    //    课程价格
    private Integer price;
    //    课程种类
    private String course_class;
    //    课程作者
    private String author;
//新增>>>
//    介绍
    private String  introduction;
    //小改后>>>
    //    状态
    private String state;
    //    课时
    private String class_hour;
    //    课程用户名
    private Integer u_id;
    //    课程收藏数量
    private Integer like;
    //    课程播放量
    private Integer view;
//
    private String uuid;
    private String vip;
//    点赞
    private Integer good;

    private Integer my_id;

}
