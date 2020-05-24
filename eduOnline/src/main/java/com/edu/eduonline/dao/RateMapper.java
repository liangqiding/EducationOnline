package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Rate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RateMapper {
    int InsRate(Rate rate);
    int SelRate(Integer date);
    int UdpRate(Rate rate);
    List<Rate> SelRateAll();
}
