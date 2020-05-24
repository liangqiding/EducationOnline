package com.edu.eduonline.service.imp;

import com.edu.eduonline.service.SaveFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/4 0004 15:11
 * @Description: TODO 封装文件操作的方法
 */
@Service
public class SaveFileServiceImp implements SaveFileService {
@Autowired
private UserServiceImp userServiceImp;

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 保存文件
     * @Date 15:18 2020/3/4 0004
     * @Param 1.file要保存的文件  2.path保存路径：默认项目静态文件路径static+path
     **/
    @Value("${images_address}")
    private    String images_address;
    @Value("${video_address}")
    private   String video_address;
    @Override
    public String saveImages_File(MultipartFile file, String path) {

        // 重构文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //        保存视频
        String FileName = null;
        try {
            if (!file.isEmpty()) {
                //获取文件后缀
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                FileName = uuid + "." + fileExt;
//             保存文件路径为 默认路径+用户id
                String p=images_address+path+"/"+userServiceImp.getShiro_U_id();
//                判断路径是否存在，不存在则删除
                isExists(p);
                file.transferTo(new File(p+"/"+FileName));
                System.out.println("保存文件>>>"+p+"/" + FileName + "   成功！");
            }else {
                return null;
            }
        } catch (IOException e) {
            System.out.println("保存文件>>>" + FileName + "   失败！");
            return null;
        }
        return userServiceImp.getShiro_U_id()+"/"+FileName;
    }

    @Override
    public String saveVideo_File(MultipartFile file, Integer courser_id) {
        // 重构文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //        保存视频
        String FileName = null;
        try {
            if (!file.isEmpty()) {
                //获取文件后缀
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                FileName = uuid + "." + fileExt;
//             保存视频文件路径为 默认路径+用户ID+课程id
                String p=video_address+userServiceImp.getShiro_U_id()+"/"+courser_id;
//                判断路径是否存在
                isExists(p);
                file.transferTo(new File(p+"/"+FileName));
                System.out.println("保存视频文件>>>"+p+"/"+ FileName + "   成功！");
            }else {
                return null;
            }
        } catch (IOException e) {
            System.out.println("保存视频文件>>>" + FileName + "   失败！");
            return null;
        }
        return userServiceImp.getShiro_U_id()+"/"+courser_id+"/"+FileName;
    }

    /**
     * @return
     * @Author 梁其定
     * @Description //TODO 删除本地文件
     * @Date 15:21 2020/3/4 0004
     * @Param
     **/
    @Override
    public Boolean deleteImages_File(String path, String filename) {
        boolean delete = new File(images_address+path +"/"+ filename).delete();
        if(delete) {
            System.out.println("删除文件>>>" + filename + "   成功！");
        }else{
            System.out.println("删除文件>>>" + filename + "   失败！");
        }
        return delete;
    }

    @Override
    public Boolean deleteVideo_File(String filename) {
        boolean delete = new File(video_address+"/"+ filename).delete();
        if(delete) {
            System.out.println("删除文件>>>" + filename + "   成功！");
        }else{
            System.out.println("删除文件>>>" + filename + "   失败！");
        }
        return delete;
    }

    /**
     * @Author 梁其定
     * @Description //TODO 判断文件夹是否存在
     * @Date 10:04 2020/3/27 0027
     * @Param
     * @return
    **/

    @Override
    public void isExists(String path) {
        File file =new File(path);
//如果文件夹不存在则创建
        if  (!file .exists()  && !file .isDirectory())
        {
            System.out.println(path+"/,===>>>不存在,执行创建目录");
            file.mkdirs();
        } else
        {
            System.out.println(path+"/,===>>>目录存在");
        }
    }
}
