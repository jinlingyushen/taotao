package com.taotao.search.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.SearchResult;

/**
 * 查询索引库商品dao
 * @author 华硕
 *
 */
@Repository
public class SearchDao {
	
	@Autowired
	private SolrServer solrServer;
	
	public SearchResult search(SolrQuery query){
		//根据query对象进行查询
		QueryResponse response = null;
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		//取查询结果
		SolrDocumentList results = response.getResults();
		//取查询结果总记录数
		long numFound = results.getNumFound();
		//把查询结果封装到SearchResult对象中
		SearchResult searchResult = new SearchResult();
		searchResult.setRecordCount(numFound);
		List<SearchItem> itemList = new ArrayList<>();
		for (SolrDocument document : results) {
			SearchItem searchItem = new SearchItem();
			searchItem.setId((String) document.get("id"));
			searchItem.setCategory_name((String) document.get("item_category_name"));
			searchItem.setImage((String) document.get("item_image"));
			searchItem.setPrice((long) document.get("item_price"));
			searchItem.setSell_point((String)document.get("item_sell_point"));
			//取高亮显示
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			List<String> list = highlighting.get(document.get("id")).get("item_title");
			String itemTitle = "";
			if (list != null && list.size() > 0) {
				itemTitle = list.get(0);
			} else {
				itemTitle = (String) document.get("item_title");
			}
			searchItem.setTitle(itemTitle);
			itemList.add(searchItem);
		}
		searchResult.setItemList(itemList);
		
		return searchResult;
	}
}
