package com.education.edu.pojo;

import lombok.Data;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/11/011 10:40
 * @descriptio 课程章节资源视频
 */
@Data
public class Chapter {
    private Integer cha_id;
    private Integer course_cha_id;
    private String video;
    private Integer cha_sum;
    private String cha_date;
    private String data;
    private String cha_name;
//    计划表
    private Integer p_id;
    private Integer p_cha_id;
    private Integer p_plan;
    private Integer p_course_id;
    private Integer u_id;

    @Override
    public String toString() {
        return "Chapter{" +
                "cha_id=" + cha_id +
                ", course_cha_id=" + course_cha_id +
                ", video='" + video + '\'' +
                ", cha_sum=" + cha_sum +
                ", cha_date='" + cha_date + '\'' +
                ", data='" + data + '\'' +
                ", cha_name='" + cha_name + '\'' +
                ", p_id=" + p_id +
                ", p_cha_id=" + p_cha_id +
                ", p_plan=" + p_plan +
                ", p_course_id=" + p_course_id +
                ", u_id=" + u_id +
                '}';
    }
}
