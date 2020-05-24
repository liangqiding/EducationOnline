package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.PlanMapper;
import com.edu.eduonline.pojo.My_plan;
import com.edu.eduonline.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/5 0005 16:54
 * @Description: TODO
 */
@Service
public class PlanServiceImp implements PlanService {
    @Autowired
    private PlanMapper planMapper;
    @Override
    public My_plan SelPlanByCha_idAndU_id(Integer cha_id, Integer u_id) {
        return planMapper.SelPlanByCha_idAndU_id(cha_id,u_id);
    }

    @Override
    public int InsertMyPlan(My_plan my_plan) {
        return planMapper.InsertMyPlan(my_plan);
    }

    @Override
    public int UpdateMy_planByCha_idAndU_id(My_plan my_plan) {
        return planMapper.UpdateMy_planByCha_idAndU_id(my_plan);
    }

    @Override
    public List<My_plan> SelPlanByCour_idAndU_id(Integer course_id, Integer u_id) {
        return planMapper.SelPlanByCour_idAndU_id(course_id,u_id);
    }

}
