package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.MyCourseMapper;
import com.edu.eduonline.pojo.MyCourse;
import com.edu.eduonline.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/6 0006 14:58
 * @Description: TODO
 */
@Service
public class MyCourseServiceImp implements MyCourseService {
    @Autowired
    private MyCourseMapper myCourseMapper;
    @Override
    public int InsertMyCourse(MyCourse myCourse) {
        return myCourseMapper.InsertMyCourse(myCourse);
    }

    @Override
    public MyCourse SelMyCourseByU_idAndCou_id(MyCourse myCourse) {
        return myCourseMapper.SelMyCourseByU_idAndCou_id(myCourse);
    }

    @Override
    public int SelMyCourseCount(MyCourse myCourse) {
        return myCourseMapper.SelMyCourseCount(myCourse);
    }

    @Override
    public int UpdateMyCourseByCourse_idAndUid(MyCourse myCourse) {
        return myCourseMapper.UpdateMyCourseByCourse_idAndUid(myCourse);
    }
}
