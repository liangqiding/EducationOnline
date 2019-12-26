package com.education.edu.service;

import com.education.edu.pojo.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/11/011 17:48
 * @descriptio
 */
public interface ChapterService {
    int InsertChapterByCid(Chapter chapter);

    //    查询所有站街根据订单
    List<Chapter> SelectChapterAllById(Integer course_cha_id);

    //    通过视频ID查找视频资源
    Chapter SelectChapterById(Integer cha_id);

    //删除章节
    int DeleteChapterByCourse_cha_id(Integer course_cha_id);
    //删除章节

    int DeleteChapterByChap_id(Integer chap_id);

//    更新章节
    int UpdataChapterByCha_id(Chapter chapter);
    //    查询我的课程目录，及其播放进度
    List<Chapter> SelectChapterAndMy_Plan(@Param(value = "u_id") Integer u_id,Integer course_cha_id);
    //    查询课程总数
    int SelCountMychapterByCourId(@Param("course_cha_id")Integer course_cha_id);
}
