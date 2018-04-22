package com.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.content.service.ContentService;
import com.taotao.jedis.JedisClient;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
/**
 * 内容管理service
 * @author 华硕
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT}")
	private String INDEX_CONTENT;
	
	/**
	 * 添加内容
	 * @param tbContent
	 * @return TaotaoResult
	 */
	@Override
	public TaotaoResult addContent(TbContent tbContent) {
		tbContent.setCreated(new Date());
		tbContent.setUpdated(new Date());
		tbContentMapper.insert(tbContent);
		//同步缓存
		//删除缓存信息
		jedisClient.hdel(INDEX_CONTENT, tbContent.getCategoryId().toString());
		return TaotaoResult.ok();
	}
	
	@Override
	public List<TbContent> getContentByCid(long categoryId) {
		//先查询缓存
		//查询缓存不能影响正常业务逻辑
		try {
			String json = jedisClient.hget(INDEX_CONTENT, categoryId+"");
			if(StringUtils.isNotBlank(json)){
				List<TbContent> list = JsonUtils.jsonToList(json,TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<TbContent> contentList = tbContentMapper.selectContentListByCategoryId(categoryId);
		//把查询结果添加到缓存
		try {
			jedisClient.hset(INDEX_CONTENT, categoryId+"", JsonUtils.objectToJson(contentList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentList;
	}

	@Override
	public void benchDelContent(List<Long> ids) {
		tbContentMapper.delBenchContent(ids);
	}

	@Override
	public void delByPrimaryKey(Long id) {
		tbContentMapper.delByPrimaryKey(id);
	}

}
