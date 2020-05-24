package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 11:30
 * @descriptio 课程表，视频观看进度表，只保存最新的学习记录
 */
@Accessors(chain = true)
@Data
@ToString
public class MyCourse {
    //    主键
    private Integer m_id;

    private Integer u_id;
    //    目前学到第几节
    private Integer m_plan;
    //    课程可能付费 付费价格
    private Integer m_price;
    //    学习日期
    private String m_date;
    //    绑定章节学习进度
    private Integer p_id;

    //播放足迹 记录上次播放位置
    private Integer footmark;
    //记录上次播放的章节
    private Integer cha_id;

    //修改后的内容>>>
    private Integer course_id;

    //    最近一次学习日期
    private String last_date;
    //
    private List<Chapter> chapterList;
}
