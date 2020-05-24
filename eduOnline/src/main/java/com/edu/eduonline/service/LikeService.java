package com.edu.eduonline.service;

import com.edu.eduonline.pojo.Like;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeService {
    int InsLike(Like like);
    int SelLikeCount(Like like);
    int DelLike(@Param("id") Integer id);
    List<Like> SelLikeAll(@Param("u_id") Integer u_id);
}
