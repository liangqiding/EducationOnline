package com.edu.eduonline.service.imp;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/11 0011 16:03
 * @Description: TODO
 */
@Service
public class GetDateImp {
    /**
     * @Author 梁其定
     * @Description //TODO 获取当前时间
     * @Date 16:04 2020/3/11 0011
     * @Param 
     * @return 
    **/
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date.getTime());
        return time;
    }
    public String getDateFormatToLong() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String time = sf.format(date.getTime());
        return time;
    }
    public int getDateFormatMouth() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
        String time = sf.format(date.getTime());
        return Integer.parseInt(time);
    }
    public long getDateFormatSecond() {
        Date date = new Date();
        return System.currentTimeMillis()/1000;
    }
}
