package com.edu.eduonline.controller.manage.Chapter;

import com.edu.eduonline.pojo.Chapter;
import com.edu.eduonline.service.imp.ChapterServiceImp;
import com.edu.eduonline.service.imp.SaveFileServiceImp;
import com.edu.eduonline.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: {梁其定}
 * @DateTime: 2020/3/3 0003 15:09
 * @Description: TODO 更新章节
 */
@Controller
@RequestMapping("/manage")
public class UpdChapterController {
    @Autowired
    private ChapterServiceImp chapterServiceImp;
    @Autowired
    private SaveFileServiceImp saveFileServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 更新章节
     * @Date 15:14 2020/3/3 0003
     * @Param
     **/
    @RequestMapping("/udpChapter")
    public String udpChapter(Chapter chapter, MultipartFile file, MultipartFile file2) {
        String VideoName = saveFileServiceImp.saveVideo_File(file,chapter.getCourse_id());
        String ImageName = saveFileServiceImp.saveImages_File(file2, "chapter");

        if (VideoName != null) {
            //                删除原视频
            Chapter chapter1 = chapterServiceImp.SelectChapterByCha_Id(chapter.getCha_id());
            saveFileServiceImp.deleteVideo_File(chapter1.getVideo());
//            保存新视频到数据中
            chapter.setVideo(VideoName);
        }
        if (ImageName != null) {
            //                删除原封面
            Chapter chapter1 = chapterServiceImp.SelectChapterByCha_Id(chapter.getCha_id());
            saveFileServiceImp.deleteImages_File("chapter", chapter1.getImages());
            chapter.setImages(ImageName);
        }
        int i = chapterServiceImp.UpdChapterByCha_id(chapter);
        if (i > 0) {
            return "/manage/table_chapter";
        }
        return "/manage/table_chapter";
    }
/**
 * @Author 梁其定
 * @Description //TODO 审核章节
 * @Date 10:07 2020/3/26 0026
 * @Param
 * @return
**/
@RequestMapping("/udpChapterAss")
public String udpChapterAss(Chapter chapter, MultipartFile file, MultipartFile file2) {
    String VideoName = saveFileServiceImp.saveVideo_File(file, chapter.getCourse_id());
    String ImageName = saveFileServiceImp.saveImages_File(file2, "chapter");

    if (VideoName != null) {
        //                删除原视频
        Chapter chapter1 = chapterServiceImp.SelectChapterByCha_Id(chapter.getCha_id());
        saveFileServiceImp.deleteVideo_File(chapter1.getVideo());
//            保存新视频到数据中
        chapter.setVideo(VideoName);
    }
    if (ImageName != null) {
        //                删除原封面
        Chapter chapter1 = chapterServiceImp.SelectChapterByCha_Id(chapter.getCha_id());
        saveFileServiceImp.deleteImages_File("chapter", chapter1.getImages());
        chapter.setImages(ImageName);
    }
    int i = chapterServiceImp.UpdChapterByCha_id(chapter);
    if (i > 0) {
        return "/manage/assessor_chapter";
    }
    return "/manage/assessor_chapter";
}
}
