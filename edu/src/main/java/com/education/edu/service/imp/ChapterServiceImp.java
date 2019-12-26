package com.education.edu.service.imp;

import com.education.edu.dao.ChapterMapper;
import com.education.edu.pojo.Chapter;
import com.education.edu.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/11/011 17:49
 * @descriptio
 */
@Service
public class ChapterServiceImp implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public int InsertChapterByCid(Chapter chapter) {
        return chapterMapper.InsertChapterByCid(chapter);
    }

    @Override
    public List<Chapter> SelectChapterAllById(Integer course_cha_id) {
        return chapterMapper.SelectChapterAllById(course_cha_id);
    }

    @Override
    public Chapter SelectChapterById(Integer cha_id) {
        return chapterMapper.SelectChapterById(cha_id);
    }

    @Override
    public int DeleteChapterByCourse_cha_id(Integer course_cha_id) {
        return chapterMapper.DeleteChapterByCourse_cha_id(course_cha_id);
    }

    @Override
    public int DeleteChapterByChap_id(Integer chap_id) {
        return chapterMapper.DeleteChapterByChap_id(chap_id);
    }

    @Override
    public int UpdataChapterByCha_id(Chapter chapter) {
        return chapterMapper.UpdataChapterByCha_id(chapter);
    }

    @Override
    public List<Chapter> SelectChapterAndMy_Plan(Integer u_id,Integer course_cha_id) {
        return chapterMapper.SelectChapterAndMy_Plan(u_id,course_cha_id);
    }

    @Override
    public int SelCountMychapterByCourId(Integer course_cha_id) {
        return chapterMapper.SelCountMychapterByCourId(course_cha_id);
    }
}
