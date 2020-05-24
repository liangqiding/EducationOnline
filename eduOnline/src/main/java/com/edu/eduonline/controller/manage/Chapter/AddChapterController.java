package com.edu.eduonline.controller.manage.Chapter;

import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.service.imp.ChapterServiceImp;
import com.edu.eduonline.service.imp.GetDateImp;
import com.edu.eduonline.service.imp.SaveFileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/3 0003 14:19
 * @Description: TODO 添加章节 >>>带文件上传>>>
 */
@Controller
@RequestMapping("/manage")
public class AddChapterController {
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    @Autowired
    private GetDateImp getDateImp;

    /**
     * @return String
     * @Author 梁其定
     * @Description //TODO 添加章节
     * @Date 13:54 2020/3/3 0003
     * @Param chapter
     **/
    @RequestMapping("/addChapter")
    public String Add(Chapter chapter, MultipartFile file, MultipartFile file2) throws Exception {
        // 如果文件不为空，写入上传路径
        String VideoName = saveFileServiceImp.saveVideo_File(file, chapter.getCourse_id());
        String ImageName = saveFileServiceImp.saveImages_File(file2, "chapter");
        String date = getDateImp.getDate();
        chapter.setCha_date(date).setImages(ImageName).setVideo(VideoName);
//        操作数据库
        try {
           chapterServiceImp.InsertChapter(chapter);
            return "/manage/table_chapter";
        } catch (Exception e) {
            return "/manage/table_chapter";
        }
    }
}
