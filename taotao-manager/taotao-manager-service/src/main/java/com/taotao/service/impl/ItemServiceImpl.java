package com.taotao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem getItemById(long id) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		return tbItem;
	}

	@Override
	public EasyUIDataGridResult getItemList(int offset, int limit) {
		Map<String,Integer> map = new HashMap<>();
		map.put("offset",offset);
		map.put("limit",limit);
		List<TbItem> list = tbItemMapper.selectByPaging(map);
		long total = tbItemMapper.selectTotalRows();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(total);
		return result;
	}

	

}
