package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/11/011 10:40
 * @descriptio 课程章节资源视频
 */
@Accessors(chain = true)
@Data
@ToString
public class Chapter {
//    章节id
    private Integer cha_id;
//    课程id
    private Integer course_id;
//    视频名
    private String video;
//    章节播放数
    private Integer cha_sum;
//    喜欢点赞数
    private Integer cha_like;
//    章节创建日期
    private String cha_date;
//    章节说明
    private String data;
//    章节名
    private String cha_name;
//    视频预览图
    private String images;

    /**
    * @Description:
    * @DateTime:
    * @Params: p_plan表
    * @Return
    */
//    计划表
    private Integer p_id;
    private Integer p_plan;
    private Integer u_id;
    private Integer m_id;

}
