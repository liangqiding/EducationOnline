package com.education.edu.dao;

import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 课程章节
 */
@Mapper
public interface ChapterMapper {
//  添加章节
    int InsertChapterByCid(Chapter chapter);
    List<Chapter> SelectChapterAllById(Integer course_cha_id);
    Chapter SelectChapterById(Integer cha_id);
    int DeleteChapterByChap_id(Integer chap_id);
    int UpdataChapterByCha_id(Chapter chapter);
    int DeleteChapterByCourse_cha_id(Integer course_cha_id);
//    查询我的课程目录，及其播放进度
    List<Chapter> SelectChapterAndMy_Plan(@Param(value = "u_id") Integer u_id,@Param(value = "course_cha_id")Integer course_cha_id);
//    查询课程总数
    int SelCountMychapterByCourId(@Param("course_cha_id")Integer course_cha_id);
}
