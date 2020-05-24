package com.edu.eduonline.controller.manage;

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
 * @DateTime: 2020/3/18 0018 15:54
 * @Description: TODO
 */
@Controller
@RequestMapping("/manage")
public class PersonalMController {
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
    @RequestMapping("/UpdPersonal")
    public String UpdPersonal(User user, MultipartFile file) {
        String name=null;
        if (!file.isEmpty()){
          name = saveFileServiceImp.saveImages_File(file, "My");
        }
        user.setU_id(userServiceImp.getShiro_U_id()).setImages(name);
        if (user==null){
            System.out.println(">>>输入空");
            return "manage/personal";
        } int i = userServiceImp.UpdUserByU_id(user);
        try {

        } catch (Exception e) {
            e.printStackTrace();
//            return "error";
        }
        return "manage/personal";
    }
    /**
     * @Author 梁其定
     * @Description //TODO 获取用户信息
     * @Date 16:08 2020/3/18 0018
     * @Param 
     * @return 
    **/
    @RequestMapping("/GetPersonal")
    @ResponseBody
    public User GetPersonal() {
        User user = userServiceImp.SelUserByID(userServiceImp.getShiro_U_id());
        System.out.println(user);
        return user;
    }
    
}
