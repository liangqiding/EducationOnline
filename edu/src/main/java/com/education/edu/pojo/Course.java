package com.education.edu.pojo;

import lombok.Data;
/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 课程
 */
@Data
public class Course {
    private Integer course_id;
    private String course_name;
    private Integer c_chapter_id;
    private Integer c_user_id;
    private String img;
    private String sumtime;
    private Integer class_id;
    private  String grade;
    private Integer sum;
    private Integer num;
private String course_date;
private Integer price;
private String course_class;
private String author;

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", c_chapter_id=" + c_chapter_id +
                ", c_user_id=" + c_user_id +
                ", img='" + img + '\'' +
                ", sumtime='" + sumtime + '\'' +
                ", class_id=" + class_id +
                ", grade='" + grade + '\'' +
                ", sum=" + sum +
                ", num=" + num +
                ", course_date='" + course_date + '\'' +
                ", price=" + price +
                ", course_class='" + course_class + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
