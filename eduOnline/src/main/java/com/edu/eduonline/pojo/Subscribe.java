package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/3/21/021 10:42
 * @descriptio
 */
@Data
@ToString
@Accessors(chain = true)
public class Subscribe extends User{
    private Integer s_id;
    private Integer u_id;
    private Integer my_id;
}
