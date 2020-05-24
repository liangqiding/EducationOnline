package com.edu.eduonline.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 分页
 */
@Accessors(chain = true)
@Data
@ToString
public class Page {
    //每页的数量
    private Integer pageSize;
    //    开始行号
    private Integer startRow;
    //当前页
    private Integer pageNum;
    //总记录数
    private Integer total;
    //总页数
    private Integer pages;
    //    判断页面是否为0
    private Boolean pageSizeZero;

}
