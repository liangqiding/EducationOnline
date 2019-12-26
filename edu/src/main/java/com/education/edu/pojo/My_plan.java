package com.education.edu.pojo;

import lombok.Data;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/18/018 9:12
 * @descriptio
 */
@Data
public class My_plan {
    private Integer p_id;
    private Integer p_cha_id;
    private Integer p_plan;
    private Integer p_course_id;
    private Integer u_id;
    private Integer m_id;

    @Override
    public String toString() {
        return "My_plan{" +
                "p_id=" + p_id +
                ", p_cha_id=" + p_cha_id +
                ", p_plan='" + p_plan + '\'' +
                ", p_course_id=" + p_course_id +
                ", u_id=" + u_id +
                '}';
    }
}
