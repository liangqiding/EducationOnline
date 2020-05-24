package com.edu.eduonline.service;

import com.edu.eduonline.pojo.My_plan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanService {
    My_plan SelPlanByCha_idAndU_id(@Param(value = "cha_id") Integer cha_id, @Param(value = "u_id")Integer u_id);
    int InsertMyPlan(My_plan my_plan);
    int UpdateMy_planByCha_idAndU_id(My_plan my_plan);
    List<My_plan> SelPlanByCour_idAndU_id(@Param(value = "course_id") Integer course_id, @Param(value = "u_id")Integer u_id);
}
