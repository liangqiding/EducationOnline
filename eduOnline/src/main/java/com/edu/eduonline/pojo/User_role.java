package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/17/017 17:14
 * @descriptio
 */
@Accessors(chain = true)
@Data
@ToString
public class User_role {
    private Integer id;
    private String authority;
}
