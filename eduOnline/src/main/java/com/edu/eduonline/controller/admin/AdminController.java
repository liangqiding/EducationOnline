package com.edu.eduonline.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/18 0018 13:57
 * @Description: TODO
 */
@Controller
public class AdminController {
    @RequestMapping("AAA")
    public String test() {
            return "login/login";
    }
}
