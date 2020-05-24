package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.LikeMapper;
import com.edu.eduonline.pojo.Like;
import com.edu.eduonline.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/6 0006 15:06
 * @Description: TODO
 */
@Service
public class LikeServiceImp implements LikeService {
    @Autowired
    private LikeMapper likeMapper;
    @Override
    public int InsLike(Like like) {
        return likeMapper.InsLike(like);
    }

    @Override
    public int SelLikeCount(Like like) {
        return likeMapper.SelLikeCount(like);
    }

    @Override
    public int DelLike(Integer id) {
        return likeMapper.DelLike(id);
    }

    @Override
    public List<Like> SelLikeAll(Integer u_id) {
        return likeMapper.SelLikeAll(u_id);
    }

}
