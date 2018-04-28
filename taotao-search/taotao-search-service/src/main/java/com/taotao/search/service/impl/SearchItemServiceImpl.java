package com.taotao.search.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.SearchItemMapper;
import com.taotao.search.service.SearchItemService;

/**
 * 导入商品到索引库
 * @author 华硕
 *
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {
	
	@Autowired
	private SearchItemMapper searchItemMapper;
	
	@Autowired
	private SolrServer solrServer;

	@Override
	public TaotaoResult importItemsToIndex() {
		
		List<SearchItem> items = searchItemMapper.getItemList();
		
		try{
			for(SearchItem item : items){
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", item.getId());
				document.addField("item_title", item.getTitle());
				document.addField("item_sell_point", item.getSell_point());
				document.addField("item_price", item.getPrice());
				document.addField("item_desc", item.getItem_desc());
				document.addField("item_category_name", item.getCategory_name());
				document.addField("item_image", item.getImage());
				solrServer.add(document);
			}
			solrServer.commit();
		}catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "导入数据失败");
		}
		
		return TaotaoResult.ok();
	}

}
