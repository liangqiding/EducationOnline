package com.education.edu.dao;

import com.education.edu.pojo.Mycourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 11:33
 * @descriptio
 */
@Mapper
public interface MycourseMapper {
//    添加个人学习课程
    int InsertMyCourse(Mycourse mycourse);
//    查询我的课程
    List<Mycourse> SelectMyCourseByUid(@Param(value = "u_id")Integer u_id);
//    Mycourse一对多查询课程目录chapter
    List<Mycourse> SelectOneCourseToMoreMYcourse(@Param(value = "u_id")Integer u_id);
//    查询课程及其子课程进度
    List<Mycourse> SelectMycourseAndMyplanByUid(@Param(value = "c_chapter_id")Integer c_chapter_id);
//    删除课程
    int DeleteMycourseByC_Cha_idandUid(@Param(value = "c_chapter_id")Integer c_chapter_id,@Param(value = "u_id")Integer u_id);
//    更新课程总进度信息
    int UpdateMycourseByC_course_idAndUid(Mycourse mycourse);
//    查询我的单个课程
    Mycourse SelMycourseByUidCourseId(@Param("u_id")Integer u_id,@Param("c_chapter_id")Integer c_chapter_id);

}
