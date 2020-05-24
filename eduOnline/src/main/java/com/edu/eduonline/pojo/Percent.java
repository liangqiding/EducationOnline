package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/13 0013 16:20
 * @Description: TODO
 */
@Accessors(chain = true)
@Data
@ToString
public class Percent {
    private Integer plan;
    private String name;
    private Integer course_id;
}
