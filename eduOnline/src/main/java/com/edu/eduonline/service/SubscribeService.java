package com.edu.eduonline.service;

import com.edu.eduonline.pojo.Subscribe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/3/21/021 10:47
 * @descriptio
 */
public interface SubscribeService {
    int InsSub(Subscribe subscribe);
    int SelSubCount(@Param("my_id") Integer my_id);
    List<Subscribe> SelSubAndUser(@Param("my_id") Integer my_id);
    int SelSubCountByMyAndHe(@Param("my_id") Integer my_id,@Param("u_id") Integer u_id);
    int DelSub(@Param("s_id") Integer s_id);
}
