package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/11 0011 14:27
 * @Description: TODO 会员表
 */
@Accessors(chain = true)
@Data
@ToString
public class Vip {
    private Integer v_id;
//    开始日期
    private String startdate;
//    总时长
    private long longtime;
//    用户ID
    private Integer u_id;
//    VIP等级
    private String grade;
    private String year;

}
