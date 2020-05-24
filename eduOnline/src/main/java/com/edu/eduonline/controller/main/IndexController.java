package com.edu.eduonline.controller.main;

import com.edu.eduonline.dao.DictMapper;
import com.edu.eduonline.pojo.Course;
import com.edu.eduonline.pojo.Dict;
import com.edu.eduonline.pojo.User;
import com.edu.eduonline.service.imp.CourseServiceImp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/2/28 0028 14:51
 * @Description: TODO网站主页面 卡片显示
 */
@RestController
@RequestMapping("/main")
public class IndexController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private DictMapper dictMapper;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 页面加载时执行
     * @Date 14:16 2020/3/10 0010
     * @Param
     **/
    @RequestMapping("/GetCourse")
    public List<Course> GetCourse(Integer pageNum, Integer pageSize, HttpSession session) {
//        重置搜索及种类切换的session
        session.removeAttribute("SearchName2");
        Course course = new Course();
        course.setState("通过");
        String searchName = (String) session.getAttribute("SearchName");
        if (searchName != null) {
            course.setCourse_name(searchName);
            session.removeAttribute("SearchName");
            session.setAttribute("SearchName2", searchName);
        }
        session.removeAttribute("mohu");
        session.removeAttribute("class_id");
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(1, 6, course);
        List<Course> list = pageInfo.getList();
        System.out.println("/GetCourse>>>" + list);
        return list;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取翻页信息
     * @Date 14:01 2020/3/10 0010
     * @Param
     **/
    @RequestMapping("/getLimit")
    public PageInfo<Course> getLimit(HttpSession session, Integer pageNum) {
        String moho = (String) session.getAttribute("mohu");
        Integer class_id = (Integer) session.getAttribute("class_id");
        String searchName = (String) session.getAttribute("SearchName2");
        Course course = new Course();
        course.setState("通过");
        if (searchName != null) {
            course.setCourse_name(searchName);
        }
        if (class_id != null) {
            course.setClass_id(class_id);
        }
        if (moho != null) {
            course.setCourse_name(moho);
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(pageNum, 6, course);
        System.out.println("pageInfo>>>" + pageInfo);
        return pageInfo;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 执行翻页
     * @Date 14:18 2020/3/10 0010
     * @Param
     **/
    @RequestMapping("/pageNext")
    public List<Course> pageNext(Integer pageNum, HttpSession session) {
        String moho = (String) session.getAttribute("mohu");
        String searchName = (String) session.getAttribute("SearchName2");
        Integer class_id = (Integer) session.getAttribute("class_id");
        if (pageNum == null) {
            pageNum = 1;
        }
        Course course = new Course();
        course.setState("通过");
        if (searchName != null) {
            course.setCourse_name(searchName);
        }
        if (class_id != null) {
            course.setClass_id(class_id);
        }
        if (moho != null) {
            course.setCourse_name(moho);
        }
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(pageNum, 6, course);
        System.out.println("pageInfo.getList()>>>" + pageInfo.getList());
        return pageInfo.getList();
    }


    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 搜索
     * @Date 15:10 2020/3/10 0010
     * @Param
     **/
    @RequestMapping("/search")
    public String search(HttpSession session, String mohu) {
        session.setAttribute("mohu", mohu);
        return "success";
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 种类切换
     * @Date 15:10 2020/3/10 0010
     * @Param
     **/
    @RequestMapping("/getClassTO")
    public String getClassTO(HttpSession session, Integer class_id) {
        session.setAttribute("class_id", class_id);
        return "success";
    }

    /**
     * @return 种类ID
     * @Author 梁其定
     * @Description //TODO 用于导航栏 种类ACTIVE
     * @Date 16:27 2020/3/10 0010
     * @Param
     **/
    @RequestMapping("/getClass_id")
    public Integer getClass_id(HttpSession session) {
        Integer class_id = (Integer) session.getAttribute("class_id");
        if (class_id == null) {
            return 0;
        }
        return class_id;
    }

    /**
     * @Author : 梁其定
     * @Date : 2020/4/12/012 12:20
     * @Description : TODO 获取导航栏种类
     * @params:
     * @Return :
     */
    @RequestMapping("/getClass")
    public List<Dict> getClassC() {
        List<Dict> dicts = dictMapper.SelDict();
        System.out.println("总共有类别："+dicts);
        return dicts;
    }
}
