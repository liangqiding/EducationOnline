package com.education.edu;

import com.education.edu.dao.ChapterMapper;
import com.education.edu.dao.CourseMapper;
import com.education.edu.dao.MycourseMapper;
import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.Course;
import com.education.edu.pojo.Mycourse;
import com.education.edu.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class EduApplicationTests {
@Autowired
private CourseMapper courseMapper;
@Autowired
private ChapterMapper chapterMapper;
@Autowired
private MycourseMapper mycourseMapper;
    @Test
    void contextLoads() {
//        获取项目路径
        String property = System.getProperty("user.dir");
        System.out.println(property);
        String [] s=property.split("\\\\");
        StringBuffer stringBuffer=new StringBuffer();
        for (String x:s){
            stringBuffer.append(x+"\\\\");
        }

        System.out.println(stringBuffer.toString());
    }
    @Test
    void test() {
//        获取项目路径
        int i = courseMapper.CountCourse();
        System.out.println(i);

    }
    @Test
    void test2() {
//
        List<Course> courses = courseMapper.SelectAllCourseByUserId(null);
        System.out.println(courses);

    }
    @Test
    void test3() {
//
        Chapter chapter = new Chapter();
        chapter.setCha_name("ceshi");
        int i = chapterMapper.InsertChapterByCid(chapter);
        System.out.println(i);

    }
    @Test
    void test4() {
//更新章节测试
        Chapter chapter = new Chapter();
        chapter.setCha_name("Mysql-03");
        chapter.setCha_id(10);
        int i = chapterMapper.UpdataChapterByCha_id(chapter);
        System.out.println(i);

    }

    //利用shiro的加密来生成密码
    @Test
    public void pwdTest(){
        //加密方式
        String hashAlgorithmName = "MD5";
        //加密次数
        int hashInteractions = 2;
        //盐值
        String salt = "lqd";
        //原密码
        String pwd = "22";
        //将得到的result放到数据库中就行了。
        String result = new SimpleHash(hashAlgorithmName, pwd, ByteSource.Util.bytes(salt), hashInteractions).toHex();
        System.out.println(result);

    }
    @Test
    public void pwdTest2(){
        String s = encryptPassword("MD5", "22", "lqd", 2);
        System.out.println(s);
    }
    public static String encryptPassword(String hashAlgorithm, String password, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash(hashAlgorithm, password, salt, hashIterations);
        return hash.toString();
    }
    @Test
    public void p(){

    }
}
