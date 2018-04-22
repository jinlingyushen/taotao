package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;

@Controller
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping(value="/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value="id",defaultValue="0") long parentId){
		List<EasyUITreeNode> resultList = contentCategoryService.getContentCategoryList(parentId);
		return resultList;
	}
	
	@RequestMapping(value="/content/category/create")
	@ResponseBody
	public TaotaoResult addContentCategory(long parentId,String name){
		TaotaoResult result = contentCategoryService.addContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping(value="/content/category/update")
	public void changeContentCategory(long id,String name){
		contentCategoryService.changeContentCategory(id, name);
	}
	
	/**
	 * 删除节点
	 * @param id
	 */
	@RequestMapping(value="/content/category/delete")
	public void delContentCategory(long id){
		contentCategoryService.delContentCategory(id);
	}
}
