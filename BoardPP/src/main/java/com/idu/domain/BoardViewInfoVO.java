package com.idu.domain;

public class BoardViewInfoVO {
	
	private Integer bno;
	private int curPage;	
	private SearchVO search;
	
	public BoardViewInfoVO(Integer bno, int curPage, String searchType, String keyword) {
		
		this.bno = bno;
		this.curPage = 1;
		if(curPage>1)
			this.curPage = curPage;
		this.search = new SearchVO(searchType,keyword);
	}

	public Integer getBno() {
		return bno;
	}

	public int getCurPage() {
		return curPage;
	}

	public SearchVO getSearch() {
		return search;
	}
	
	
	

}
