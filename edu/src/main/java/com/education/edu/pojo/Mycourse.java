package com.education.edu.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 11:30
 * @descriptio 学生个人课程
 */
@Data
public class Mycourse {
    private Integer u_id;
    private Integer m_id;
    private Integer c_chapter_id;
    private String m_name;
    private Integer  m_plan;
    private Integer m_price;
    private String  m_date;
    private String  m_author;
    private String  m_img;
    private List<Chapter> chapterList;

    private Integer p_id;
    private Integer p_cha_id;
    private Integer p_plan;
    private Integer p_course_id;

    @Override
    public String toString() {
        return "Mycourse{" +
                "u_id=" + u_id +
                ", m_id=" + m_id +
                ", c_chapter_id=" + c_chapter_id +
                ", m_name='" + m_name + '\'' +
                ", m_plan='" + m_plan + '\'' +
                ", m_price=" + m_price +
                ", m_date='" + m_date + '\'' +
                ", m_author='" + m_author + '\'' +
                ", m_img='" + m_img + '\'' +
                ", chapterList=" + chapterList +
                '}';
    }
}
