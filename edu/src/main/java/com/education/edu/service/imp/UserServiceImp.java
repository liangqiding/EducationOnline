package com.education.edu.service.imp;

import com.education.edu.dao.UserMapper;
import com.education.edu.pojo.User;
import com.education.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 用户业务层
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> SelectUserByUser(User user) {
        return userMapper.SelectUserByUser(user);
    }

    @Override
    public int InsterUser(User user) {
        return userMapper.InsterUser(user);
    }

    @Override
    public User SelectUserByUsername(String  username) {
        return userMapper.SelectUserByUsername(username);
    }


}
