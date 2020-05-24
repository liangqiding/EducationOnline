package com.edu.eduonline.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface SaveFileService {
//    文件保存
    String saveImages_File(MultipartFile file, String path);
    String saveVideo_File(MultipartFile file,Integer course_id);
//    文件删除
    Boolean deleteImages_File(String path, String filename);

    Boolean deleteVideo_File( String filename);

    void isExists(String path);
}
