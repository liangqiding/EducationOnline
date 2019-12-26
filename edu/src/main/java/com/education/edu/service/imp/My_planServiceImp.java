package com.education.edu.service.imp;

import com.education.edu.dao.MyplanMapper;
import com.education.edu.pojo.My_plan;
import com.education.edu.service.My_planService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/18/018 9:29
 * @descriptio
 */
@Service
public class My_planServiceImp implements My_planService {
    @Autowired
    private MyplanMapper myplanMapper;
    @Override
    public int InsertMyPlan(My_plan my_plan) {
        return myplanMapper.InsertMyPlan(my_plan);
    }

    @Override
    public int UpdateMy_planByCha_id(My_plan my_plan) {
        return myplanMapper.UpdateMy_planByCha_id(my_plan);
    }

    @Override
    public My_plan SelectMyPlanByCha_id(Integer p_cha_id, Integer u_id) {
        return myplanMapper.SelectMyPlanByCha_id(p_cha_id, u_id);
    }

    @Override
    public int DelMy_plan(Integer u_id, Integer p_course_id) {
        return myplanMapper.DelMy_plan(u_id,p_course_id);
    }


}
