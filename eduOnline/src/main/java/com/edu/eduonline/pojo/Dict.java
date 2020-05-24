package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/4/12/012 12:09
 * @descriptio
 */
@Data
@ToString
@Accessors(chain = true)
public class Dict {
    private Integer dict_id;
    private String course_class;
}

