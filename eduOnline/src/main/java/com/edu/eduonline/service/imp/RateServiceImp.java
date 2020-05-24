package com.edu.eduonline.service.imp;

import com.edu.eduonline.dao.RateMapper;
import com.edu.eduonline.pojo.Rate;
import com.edu.eduonline.service.RateService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/19 0019 15:42
 * @Description: TODO
 */
@Service
public class RateServiceImp implements RateService{
    @Autowired
    private RateMapper rateMapper;
    @Override
    public int InsRate(Rate rate) {
        return rateMapper.InsRate(rate);
    }
    @Override
    public int SelRate(Integer date) {
        return rateMapper.SelRate(date);
    }
    @Override
    public int UdpRate(Rate rate) {
        return rateMapper.UdpRate(rate);
    }

    @Override
    public List<Rate> SelRateAll() {
        return rateMapper.SelRateAll();
    }
}
