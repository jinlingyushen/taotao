package com.taotao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.taotao.pojo.TbContent;
/**
 * 内容管理Mapper
 * @author 华硕
 *
 */
public interface TbContentMapper {
	/**
	 * 添加内容
	 * @param tbContent
	 */
	void insert(TbContent tbContent);
	/**
	 * 通过类目id查询内容
	 * @param categoryId
	 * @return
	 */
	List<TbContent> selectContentListByCategoryId(Long categoryId);
	/**
	 * 批量删除内容
	 * @param idList
	 */
	void delBenchContent(@Param("idList")List<Long> idList);
	/**
	 * 通过主键删除内容
	 * @param id
	 * @return
	 */
	int delByPrimaryKey(Long id);

}
