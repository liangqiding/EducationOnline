package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/6 0006 15:01
 * @Description: TODO 收藏列表
 */
@Accessors(chain = true)
@Data
@ToString
public class Like {
    private Integer id;
    private Integer u_id;
    private Integer course_id;


//    >>>course
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
    //    章节id
    private Integer chapter_id;
    //    课时
    private String class_hour;
    //    课程收藏数量
    private Integer like;
    //    课程播放量
    private Integer view;
}
