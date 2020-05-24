package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.UserMapper;
import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.UserService;
import org.apache.shiro.SecurityUtils;
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
    @Override
    public int getShiro_U_id() {
            Integer u_id = 0;
            try {
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                u_id = user.getU_id();
            } catch (Exception e) {
                return 0;
            }
            return u_id;
        }
    @Override
    public User SelUserByID(Integer u_id) {
        return userMapper.SelUserByID(u_id);
    }

    @Override
    public int UpdUserByU_id(User user) {
        return userMapper.UpdUserByU_id(user);
    }

    @Override
    public List<User> SelUserAll() {
        return userMapper.SelUserAll();
    }
}
