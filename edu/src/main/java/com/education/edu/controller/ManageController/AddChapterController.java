package com.education.edu.controller.ManageController;
import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.Course;
import com.education.edu.service.imp.ChapterServiceImp;
import com.education.edu.service.imp.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/11/011 11:33
 * @descriptio 添加课程章节视频资源
 */
@Controller
public class AddChapterController {
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @RequestMapping("/addChapter")
    public String Add(String cha_name,String data,Integer c_chapter_id,@RequestParam("file") MultipartFile file) throws Exception{
        // 如果文件不为空，写入上传路径
        System.out.println(c_chapter_id+cha_name+data);
        String newVidoeName=null;
        try {
            if (!file.isEmpty() ){
                //获取文件后缀
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                        .toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                newVidoeName = pikId + "." + fileExt;
                //保存视频
                //        获取项目路径
                String property = System.getProperty("user.dir");
                String s1 = property.replaceAll("\\\\", "/");
                String s2="/src/main/resources/static/video/";
                String path=s1+s2;
                System.out.println("文件保存路径："+path);
                //创建文件路径
                // 判断路径是否存在，如果不存在就创建一个
                // 将上传文件保存到一个目标文件当中
                file.transferTo(new File( path + newVidoeName));
                System.out.println("文件名："+newVidoeName);
            }
        } catch (IOException e) {
            System.out.println("上传失败");
        }
        Chapter chapter = new Chapter();
        chapter.setCha_name(cha_name);
//        添加创建日期
        //    设置创建时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date.getTime());
        chapter.setCha_date(time);
//        绑定视频名称
        chapter.setVideo(newVidoeName);
//        添加章节视频说明
        chapter.setData(data);
//        绑定课程ID
        chapter.setCourse_cha_id(c_chapter_id);
//        操作数据库
        int i = chapterServiceImp.InsertChapterByCid(chapter);
        System.out.println(i);
        return "manage/table-basic2";
    }
}
