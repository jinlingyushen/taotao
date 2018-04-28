package com.taotao.search.service;

import com.taotao.common.pojo.SearchResult;

public interface SearchService {
	
	SearchResult search (String queryStr,int page,int rows);
}
