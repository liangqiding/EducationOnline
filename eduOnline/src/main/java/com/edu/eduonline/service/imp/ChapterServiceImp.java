package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.ChapterMapper;
import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/3/2 0002 16:52
 * @Description: TODO
 */
@Service
public class ChapterServiceImp implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;


    @Override
    public List<Chapter> SelectChapterAllByCourse_id(Integer course_id, Integer u_id) {
        return chapterMapper.SelectChapterAllByCourse_id(course_id,u_id);
    }

    @Override
    public Chapter SelectChapterByChap_Id(Integer cha_id, Integer u_id) {
        return chapterMapper.SelectChapterByChap_Id(cha_id,u_id);
    }

    @Override
    public int InsertChapter(Chapter chapter) {
        return chapterMapper.InsertChapter(chapter);
    }

    @Override
    public int DelChapter(Integer cha_id) {
        return chapterMapper.DelChapter(cha_id);
    }

    @Override
    public int UpdChapterByCha_id(Chapter chapter) {
        return chapterMapper.UpdChapterByCha_id(chapter);
    }

    @Override
    public List<Chapter> SelChapterByCourse_id(Integer course_id) {
        return chapterMapper.SelChapterByCourse_id(course_id);
    }

    @Override
    public Chapter SelectChapterByCha_Id(Integer cha_id) {
        return chapterMapper.SelectChapterByCha_Id(cha_id);
    }


}
