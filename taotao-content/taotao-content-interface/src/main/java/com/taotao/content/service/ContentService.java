package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
/**
 * 内容管理service
 * @author 华硕
 *
 */
public interface ContentService {
	/**
	 * 添加内容
	 * @param tbContent
	 * @return
	 */
	TaotaoResult addContent(TbContent tbContent);
	/**
	 * 根据类目id查询内容
	 * @param categoryId
	 * @return
	 */
	List<TbContent> getContentByCid(long categoryId);
	/**
	 * 批量删除内容
	 * @param ids
	 * @return
	 */
	void benchDelContent(List<Long> ids);
	/**
	 * 通过主键删除内容
	 * @param id
	 * @return
	 */
	void delByPrimaryKey(Long id);
}
