package com.edu.eduonline.controller.main;

import com.edu.eduonline.pojo.*;
import com.edu.eduonline.service.imp.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/4 0004 16:45
 * @Description: TODO 获取视频资源
 */
@RestController
@RequestMapping("/vip")
public class VideoController {
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private LikeServiceImp likeServiceImp;
    @Autowired
    private MyCourseServiceImp myCourseServiceImp;
    @Autowired
    private VipServiceImp vipServiceImp;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取播放的视频
     * @Date 14:26 2020/3/5 0005
     * @Param
     **/
    @RequestMapping("/getVideoForVideo")
    public Chapter Test(HttpSession session, Integer cha_id) {
        Chapter c = new Chapter();
        if (cha_id != null) {//判断是否指定播放
            c = chapterServiceImp.SelectChapterByChap_Id(cha_id, userServiceImp.getShiro_U_id());
            session.setAttribute("plan", 1);
        } else {
//            播放第一个视频
            Integer course_id = (Integer) session.getAttribute("main/course_id");
            MyCourse myCourse = new MyCourse();
            myCourse.setU_id(userServiceImp.getShiro_U_id());
            myCourse.setCourse_id(course_id);
            MyCourse myCourse1 = myCourseServiceImp.SelMyCourseByU_idAndCou_id(myCourse);
//            判断
            try {
                int cha_id2 = myCourse1.getCha_id();
                c = chapterServiceImp.SelectChapterByChap_Id(cha_id2, userServiceImp.getShiro_U_id());
            } catch (Exception e) {
                //默认播放第一个视频
                List<Chapter> chapters = chapterServiceImp.SelChapterByCourse_id(course_id);
                //        默认显示第一个
//            Iterator<Chapter> iterator = chapters.iterator();
//            c = iterator.next();
                for (Chapter chap : chapters
                ) {
                    c = chap;
                    break;
                }
            }
        }
        System.out.println(c);
        return c;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取播放的课程
     * @Date 14:27 2020/3/5 0005
     * @Param
     **/
    @RequestMapping("/getCourseForVideo")
    public Course test(HttpSession session) {
        Integer course_id = (Integer) session.getAttribute("main/course_id");
        Course course = courseServiceImp.SelCourseById(course_id);
        System.out.println("course>>>" + course);
        return course;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取章节列表
     * @Date 14:03 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/GetChapterForVideo")
    public List<Chapter> GetChapterList(HttpSession session) {
        Integer course_id = (Integer) session.getAttribute("main/course_id");
        List<Chapter> chapters = chapterServiceImp.SelectChapterAllByCourse_id(course_id, userServiceImp.getShiro_U_id());
        System.out.println("获取章节列表>>>" + chapters);
//        通过id排序后输出
        List<Chapter> sortedChapters = chapters.stream().sorted(Comparator.comparing(Chapter::getCha_id)).collect(Collectors.toList());
        return sortedChapters;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 获取改教师的推荐课程 按播放量高->低
     * @Date 15:42 2020/3/5 0005
     * @Param
     **/
    @RequestMapping("/getCourseListForVideo")
    public List<Course> getCourseListForVideo(HttpSession session) {
        Integer course_id = (Integer) session.getAttribute("main/course_id");
        Course course1 = courseServiceImp.SelCourseById(course_id);
        Course course = new Course();
        course.setU_id(course1.getU_id());
        PageInfo<Course> pageInfo = courseServiceImp.SelCourse(1, 4, course);
//        todo 按播放量排序
        List<Course> collect = pageInfo.getList().stream().sorted(Comparator.comparing(Course::getView).reversed()).collect(Collectors.toList());
        return collect;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 判断是否点赞和收藏
     * @Date 11:34 2020/3/19 0019
     * @Param
     **/
    @RequestMapping("/getLikeAndGoodLater")
    public String[] getLikeAndGoodLater(HttpSession session) {
        Integer course_id = (Integer) session.getAttribute("main/course_id");
        int u_id = userServiceImp.getShiro_U_id();
        String[] arr = new String[2];
        List<Like> likeList = likeServiceImp.SelLikeAll(u_id);
        boolean b = likeList.stream().anyMatch(like -> like.getCourse_id() == course_id);
        if (b) {
            arr[0] = "false";
        } else
            arr[0] = "true";
        StaticMap.MapKey mapViewKey = new StaticMap.MapKey().setCourse_id(course_id).setU_id(u_id);
        boolean b2 = StaticMap.goodMap.containsKey(mapViewKey);
        if (b2) {
            arr[1] = "false";
        } else
            arr[1] = "true";
        System.out.println(arr[0] + arr[1]);
        return arr;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 判断会员状态
     * @Date 11:22 2020/3/20 0020
     * @Param
     **/
    @RequestMapping("/getVipBoolean")
    public String getVipBoolean() {
        int u_id = userServiceImp.getShiro_U_id();
        if (StaticMap.vipMap.containsKey(u_id)) {//假如包含
            String s = StaticMap.vipMap.get(u_id);
            return s;
        }//不包含则从数据查询
        boolean b = vipServiceImp.booleanVip();
        if (b) {
            StaticMap.vipMap.put(u_id,"true");
            return "true";
        }
        StaticMap.vipMap.put(u_id,"false");
        return "false";
    }
}
