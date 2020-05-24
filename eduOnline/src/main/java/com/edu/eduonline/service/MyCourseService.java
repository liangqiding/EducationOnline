package com.edu.eduonline.service;

import com.edu.eduonline.pojo.MyCourse;

public interface MyCourseService {
    int InsertMyCourse(MyCourse myCourse);
    MyCourse SelMyCourseByU_idAndCou_id(MyCourse myCourse);
    int SelMyCourseCount(MyCourse myCourse);
    int UpdateMyCourseByCourse_idAndUid(MyCourse myCourse);
}
