package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.SubscribeMapper;
import com.edu.eduonline.pojo.Subscribe;
import com.edu.eduonline.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/3/21/021 10:47
 * @descriptio
 */
@Service
public class SubscribeServiceImp implements SubscribeService {
@Autowired
private SubscribeMapper subscribeMapper;
    @Override
    public int InsSub(Subscribe subscribe) {
        return subscribeMapper.InsSub(subscribe);
    }

    @Override
    public int SelSubCount(Integer my_id) {
        return subscribeMapper.SelSubCount(my_id);
    }

    @Override
    public List<Subscribe> SelSubAndUser(Integer my_id) {
        return subscribeMapper.SelSubAndUser(my_id );
    }


    @Override
    public int SelSubCountByMyAndHe(Integer my_id, Integer u_id) {
        return subscribeMapper.SelSubCountByMyAndHe(my_id,u_id);
    }

    @Override
    public int DelSub(Integer s_id) {
        return subscribeMapper.DelSub(s_id);
    }
}
