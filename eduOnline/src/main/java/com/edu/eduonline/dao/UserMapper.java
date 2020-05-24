package com.edu.eduonline.dao;


import com.edu.eduonline.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:51
 * @descriptio 用户
 */
@Mapper
public interface UserMapper {
    List<User> SelectUserByUser(User user);
    int InsterUser(User user);
    User SelectUserByUsername(String username);
    User SelUserByID(Integer u_id);
    int UpdUserByU_id(User user);
    List<User> SelUserAll();
}
