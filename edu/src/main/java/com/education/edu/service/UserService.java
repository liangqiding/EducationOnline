package com.education.edu.service;

import com.education.edu.pojo.User;

import java.util.List;
/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 用户业务接口
 */
public interface UserService {
    List<User> SelectUserByUser(User user);
    int   InsterUser (User user);
//    查询user
   User SelectUserByUsername(String  username);
}
