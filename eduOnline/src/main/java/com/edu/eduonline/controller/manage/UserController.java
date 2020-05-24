package com.edu.eduonline.controller.manage;

import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/19 0019 9:00
 * @Description: TODO user.html
 */
@RestController
@RequestMapping("/manage")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    /**
     * @Author 梁其定
     * @Description //TODO 获取用户信息
     * @Date 9:02 2020/3/19 0019
     * @Param
     * @return
    **/
    @RequestMapping("/getUserAll")
    public List<User> getUserAll() {
        List<User> user = userServiceImp.SelUserAll();
        List<User> collect = user.stream().sorted(Comparator.comparing(User::getU_id).reversed()).collect(Collectors.toList());
        return collect;
    }
}
