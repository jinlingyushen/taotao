package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;

@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/add")
	@ResponseBody
	public TaotaoResult addContent(@RequestBody TbContent tbContent){
		contentService.addContent(tbContent);
		return TaotaoResult.ok();
	}
	/**
	 * 批量删除内容
	 * @param ids
	 * @return
	 */
	@RequestMapping("/content/bench/del")
	@ResponseBody
	public TaotaoResult delContentByBench(@RequestBody List<Long> ids){
		contentService.benchDelContent(ids);
		return TaotaoResult.ok();
	}
	@RequestMapping("/content/del")
	@ResponseBody
	public TaotaoResult delByPrimaryKey(Long id){
		contentService.delByPrimaryKey(id);
		return TaotaoResult.ok();
	}
}
