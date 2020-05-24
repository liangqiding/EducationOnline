package com.edu.eduonline.controller.main.My;

import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.SaveFileServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/18 0018 15:53
 * @Description: TODO
 */
@Controller
@RequestMapping("/vip")
public class MyPersonalController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    /**
     * @Author 梁其定
     * @Description //TODO 更新用户信息
     * @Date 16:08 2020/3/18 0018
     * @Param
     * @return
     **/
    @RequestMapping("/UpdPersonalMain")
    public String UpdPersonal(User user, MultipartFile file) {
        String name=null;
        if (!file.isEmpty()){
             name = saveFileServiceImp.saveImages_File(file, "My");
        }
//        删除原图片
        user.setU_id(userServiceImp.getShiro_U_id()).setImages(name);
        try {
            User user1 = userServiceImp.SelUserByID(userServiceImp.getShiro_U_id());
            saveFileServiceImp.deleteImages_File("My", user1.getImages());
        } catch (Exception e) {
            System.out.println("删除原头像失败！");
        }
        if (user==null){
            System.out.println(">>>输入空");
            return "manage/personal";
        } int i = userServiceImp.UpdUserByU_id(user);
        try {

        } catch (Exception e) {
            e.printStackTrace();
//            return "error";
        }
        return "main/my/personal";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 获取当个用户信息
     * @Date 14:18 2020/3/19 0019
     * @Param
     * @return
    **/
    @RequestMapping("/GetUserMain")
    @ResponseBody
    public User GetPersonal() {
        User user = userServiceImp.SelUserByID(userServiceImp.getShiro_U_id());
        System.out.println(user);
        return user;
    }
}
