package com.education.edu.controller.ManageController;

import com.education.edu.pojo.Chapter;
import com.education.edu.service.imp.ChapterServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/13/013 8:49
 * @descriptio 更新章节
 */
@Controller
public class UpdataChapterController {
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @RequestMapping("/updataChapter")
    public String UpdataChapter(String cha_name,String data,Integer cha_id, @RequestParam("file") MultipartFile file) throws IOException {
        Chapter chapter = new Chapter();
        if(cha_name.equals("")&&data.equals("")&&file.isEmpty()){
            System.out.println("没有修改！");
            return "manage/table-basic2";
        }
//        获取上传文件
        String newVidoeName = null;
        try {
            if (!file.isEmpty()) {
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
                String s2 = "/src/main/resources/static/images/";
                String path = s1 + s2;
                System.out.println("文件保存路径：" + path);
                //创建文件路径
                // 判断路径是否存在，如果不存在就创建一个
                // 将上传文件保存到一个目标文件当中
                file.transferTo(new File(path + newVidoeName));
                System.out.println("文件名：" + newVidoeName);
//                封装视频名字
                chapter.setVideo(newVidoeName);
            }
        } catch (IOException e) {
            System.out.println("上传失败");
        }
        chapter.setCha_name(cha_name);
        chapter.setCha_id(cha_id);
        chapter.setData(data);
        System.out.println(data+cha_name+cha_id);
        int i = chapterServiceImp.UpdataChapterByCha_id(chapter);
        System.out.println("updataChapter="+i);
        return "manage/table-basic2";
    }
}
