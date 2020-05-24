package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeMapper {
    int InsLike(Like like);
    int SelLikeCount(Like like);
//    删除表
    int DelLike(@Param("id") Integer id);
//
List<Like> SelLikeAll(@Param("u_id") Integer u_id);
}
