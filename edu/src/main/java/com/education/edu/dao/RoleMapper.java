package com.education.edu.dao;

import com.education.edu.pojo.User_role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/17/017 17:16
 * @descriptio
 */
@Mapper
public interface RoleMapper {
    User_role SelectRoleById(@Param(value = "id")Integer id);
}
