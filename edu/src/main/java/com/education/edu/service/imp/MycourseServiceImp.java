package com.education.edu.service.imp;

import com.education.edu.dao.MycourseMapper;
import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.My_plan;
import com.education.edu.pojo.Mycourse;
import com.education.edu.pojo.User;
import com.education.edu.service.MycourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 11:34
 * @descriptio 个人课程管理
 */
@Service
public class MycourseServiceImp implements MycourseService {
    @Autowired
    private MycourseMapper mycourseMapper;
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private My_planServiceImp my_planServiceImp;

    @Override
    public int InsertMyCourse(Mycourse mycourse,Integer c_chapter_id) {
        User user= (User) SecurityUtils.getSubject().getPrincipal();
//        生成课程表
        int a=  mycourseMapper.InsertMyCourse(mycourse);
//        生成进度表
        List<Chapter> chapter = chapterServiceImp.SelectChapterAllById(c_chapter_id);
        My_plan my_plan=new My_plan();
        int sum=0,b=0;
        for (Chapter c : chapter
        ) {
            my_plan.setP_cha_id(c.getCha_id());
            my_plan.setP_course_id(c_chapter_id);
            my_plan.setP_plan(0);
            my_plan.setU_id(user.getUser_id());
            b=my_planServiceImp.InsertMyPlan(my_plan);
            sum+=b;
        }
        System.out.println("生成进度表数量为："+sum);
        return a;
    }

    @Override
    public PageInfo<Mycourse> SelectMyCourseByUid(Integer u_id, Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Mycourse> mycourses = mycourseMapper.SelectMyCourseByUid(u_id);
        PageInfo<Mycourse> pageInfo = new PageInfo<>(mycourses);
        return pageInfo;
    }

    @Override
    public List<Mycourse> SelectOneCourseToMoreMYcourse(Integer u_id) {
        return mycourseMapper.SelectOneCourseToMoreMYcourse(u_id);
    }

    @Override
    public List<Mycourse> SelectMycourseAndMyplanByUid(Integer c_chapter_id) {
        return mycourseMapper.SelectMycourseAndMyplanByUid(c_chapter_id);
    }

    @Override
    public int DeleteMycourseByC_Cha_idandUid(Integer c_chapter_id, Integer u_id) {
        return mycourseMapper.DeleteMycourseByC_Cha_idandUid(c_chapter_id,u_id);
    }

    @Override
    public int UpdateMycourseByC_course_idAndUid(Mycourse mycourse) {
        return mycourseMapper.UpdateMycourseByC_course_idAndUid(mycourse);
    }

    @Override
    public Mycourse SelMycourseByUidCourseId(Integer u_id, Integer c_chapter_id) {
        return mycourseMapper.SelMycourseByUidCourseId(u_id,c_chapter_id);
    }


}
