package com.edu.eduonline.service;

import com.edu.eduonline.pojo.Rate;

import java.util.List;

public interface RateService {
    int InsRate(Rate rate);
    int SelRate(Integer date);
    int UdpRate(Rate rate);
    List<Rate> SelRateAll();

}
