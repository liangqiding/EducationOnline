package com.education.edu.service;

import com.education.edu.pojo.Mycourse;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 11:34
 * @descriptio 我的课程
 */
public interface MycourseService {
//    生成课程表 及其子目录课程
    int InsertMyCourse(Mycourse mycourse,Integer c_chapter_id);
    PageInfo<Mycourse> SelectMyCourseByUid(Integer u_id, Integer pageNum);
    List<Mycourse> SelectOneCourseToMoreMYcourse(@Param(value = "u_id")Integer u_id);
//    查询课程及其子课程进度
    List<Mycourse> SelectMycourseAndMyplanByUid(@Param(value = "c_chapter_id")Integer c_chapter_id);

    int DeleteMycourseByC_Cha_idandUid(@Param(value = "c_chapter_id")Integer c_chapter_id,@Param(value = "u_id")Integer u_id);
    //    更新课程总进度信息
    int UpdateMycourseByC_course_idAndUid(Mycourse mycourse);
    //    查询我的单个课程
    Mycourse SelMycourseByUidCourseId(@Param("u_id")Integer u_id,@Param("c_chapter_id")Integer c_chapter_id);
}
