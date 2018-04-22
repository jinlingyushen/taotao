package com.taotao.service;


import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(long id);
	EasyUIDataGridResult getItemList(int offset,int limit);
}
