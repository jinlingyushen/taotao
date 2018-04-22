package com.taotao.mapper;

import java.util.List;
import java.util.Map;

import com.taotao.pojo.TbItem;

public interface TbItemMapper {

    TbItem selectByPrimaryKey(Long id);
    List<TbItem> selectByPaging(Map<String,Integer> map);
    Long selectTotalRows();

}