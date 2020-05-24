package com.edu.eduonline.service;

import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterService {
    //获取视频章节
    List<Chapter> SelectChapterAllByCourse_id(@Param("course_id") Integer course_id, @Param("u_id") Integer u_id);
    //    通过ID查询章节
    Chapter SelectChapterByChap_Id(@Param("cha_id") Integer cha_id,@Param("u_id") Integer u_id);

    //    章节添加
    int InsertChapter(Chapter chapter);

    //    章节删除
    int DelChapter(Integer cha_id);

    //    章节更新
    int UpdChapterByCha_id(Chapter chapter);
    List<Chapter> SelChapterByCourse_id(@Param("course_id") Integer course_id);
    Chapter SelectChapterByCha_Id(@Param("cha_id") Integer cha_id);


}
