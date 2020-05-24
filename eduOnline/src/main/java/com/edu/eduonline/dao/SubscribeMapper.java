package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Subscribe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/3/21/021 10:45
 * @descriptio
 */
@Mapper
public interface SubscribeMapper {
    int InsSub(Subscribe subscribe);
    int SelSubCount(@Param("my_id") Integer my_id);
    List<Subscribe> SelSubAndUser(@Param("my_id") Integer my_id);
    int SelSubCountByMyAndHe(@Param("my_id") Integer my_id,@Param("u_id") Integer u_id);
    int DelSub(@Param("s_id") Integer s_id);
}
