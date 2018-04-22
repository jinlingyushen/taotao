package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;

@Controller
public class TbItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@ResponseBody
	@RequestMapping("/item/cat/list")
	public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id", defaultValue="0")long parentId){
		List<EasyUITreeNode> result = itemCatService.getItemCatList(parentId);
		return result;
	}
}
