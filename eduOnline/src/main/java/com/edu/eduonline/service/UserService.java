package com.edu.eduonline.service;


import com.edu.eduonline.pojo.User;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 用户业务接口
 */
public interface UserService {
    List<User> SelectUserByUser(User user);

    //    注册
    int InsterUser(User user);

    //    查询user
    User SelectUserByUsername(String username);
//获取u_id
    int getShiro_U_id();
    User SelUserByID(Integer u_id);
    int UpdUserByU_id(User user);
    List<User> SelUserAll();
}
