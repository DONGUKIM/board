package com.idu.domain;

public class SearchVO {

	String searchType;
	String keyword;
	
	public SearchVO(String searchType, String keyword) {
	
		this.searchType = searchType;
		this.keyword = keyword;
		
		
	}
	public String getSearchType() {
		return searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	
	
}
