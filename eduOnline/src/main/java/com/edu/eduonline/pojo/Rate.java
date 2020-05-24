package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/19 0019 15:40
 * @Description: TODO
 */
@Data
@ToString
@Accessors(chain = true)
public class Rate extends Percent{
    private Integer id;
    private Integer u_id;
    private Integer sum;
    private Integer date;
    private String state;
}
