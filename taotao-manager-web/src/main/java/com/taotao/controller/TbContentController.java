package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;

/**
 * 内容管理controller
 * @author 华硕
 *
 */
@Controller
public class TbContentController {
	
	@Autowired
	private ContentService contentService;
	
	/**
	 * 添加内容
	 * @param tbContent
	 * @return
	 */
	@RequestMapping(value="/content/save")
	@ResponseBody
	public TaotaoResult addContent(TbContent tbContent){
		TaotaoResult result = contentService.addContent(tbContent);
		return result;
	}
}
