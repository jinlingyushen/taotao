package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.SearchItemService;

@Controller
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;
	@RequestMapping(value="/index/import")
	@ResponseBody
	public TaotaoResult addItemIntoIdex(){
		TaotaoResult result = searchItemService.importItemsToIndex();
		return result;
	}
}