package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 梁其定
 * @version 2.0
 * @date 2019/12/18/018 9:12
 * @descriptio 视频播放进度
 */
@Accessors(chain = true)
@ToString
@Data
public class My_plan {
    private Integer p_id;
    private Integer p_plan;
    private Integer u_id;
    private Integer m_id;

//    修改后
    private Integer cha_id;
    private Integer course_id;
}
