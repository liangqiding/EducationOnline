package com.edu.eduonline.dao;

import com.edu.eduonline.pojo.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/4/12/012 12:09
 * @descriptio
 */
@Mapper
public interface DictMapper {
    List<Dict> SelDict();
}
