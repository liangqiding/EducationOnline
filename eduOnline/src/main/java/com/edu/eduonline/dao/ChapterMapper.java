package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 视频章节
 */
@Mapper
public interface ChapterMapper {
    //获取视频章节>>>左连plan表>>>加u_id 避免plan表查出多行数据
    List<Chapter> SelectChapterAllByCourse_id(@Param("course_id") Integer course_id, @Param("u_id") Integer u_id);
    //获取视频章节>>>
    List<Chapter> SelChapterByCourse_id(@Param("course_id") Integer course_id);
    //    通过ID查询章节
    Chapter SelectChapterByChap_Id(@Param("cha_id") Integer course_id, @Param("u_id") Integer u_id);
//    非连接查询
    Chapter SelectChapterByCha_Id(@Param("cha_id") Integer cha_id);

    //    添加章节
    int InsertChapter(Chapter chapter);

    //    删除章节
    int DelChapter(Integer cha_id);

    //    更新chapter
    int UpdChapterByCha_id(Chapter chapter);



}
