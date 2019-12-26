package com.education.edu.dao;

import com.education.edu.pojo.My_plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/18/018 9:24
 * @descriptio
 */
@Mapper
public interface MyplanMapper {
    int InsertMyPlan(My_plan my_plan);
//    更新学习进度
    int UpdateMy_planByCha_id(My_plan my_plan);
//    查询进度
    My_plan SelectMyPlanByCha_id(@Param("p_cha_id") Integer p_cha_id,@Param("u_id") Integer u_id);
    int DelMy_plan(@Param("u_id") Integer u_id,@Param("p_course_id") Integer p_course_id);
}
