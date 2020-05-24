package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.MyCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyCourseMapper {
    int InsertMyCourse(MyCourse myCourse);
    MyCourse SelMyCourseByU_idAndCou_id(MyCourse myCourse);
    int SelMyCourseCount(MyCourse myCourse);
    int UpdateMyCourseByCourse_idAndUid(MyCourse myCourse);
}
