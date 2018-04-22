package com.taotao.mapper;

import java.util.List;

import com.taotao.pojo.TbContentCategory;

public interface TbContentCategoryMapper {
	List<TbContentCategory> selectContentCategory(long parentId);
	void insert(TbContentCategory tbContentCategory);
	TbContentCategory selectByPrimaryKey(long id);
	void updateByPrimaryKey(TbContentCategory tbContentCategory);
	void updateByPrimaryKeySelective(TbContentCategory tbContentCategory);
	void delContentCategoryByPrimaryKey(long id);
}
