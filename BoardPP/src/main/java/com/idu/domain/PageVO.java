package com.idu.domain;

public class PageVO {
	
	int totalContent;
	int totalPage; 
	int curPage;
	int firstPage;
	int lastPage;
	int firstContent;
	boolean prevButton=true;
	boolean nextButton=true;
	int contentLimit = 10;
	int pageLimit = 5;
	
	public PageVO(int curPage,int totalContent)
	{
		this.curPage=curPage;
		this.totalContent=totalContent;
		totalPage();
		if(curPage>totalPage)
			this.curPage=1;
		calculatePage();
		calculateContent();
		visiblePrev();
		visibleNext();
		
	}
	
	private void totalPage() {
		
		totalPage=totalContent/contentLimit;
		
		if(totalPage%contentLimit>0)
		totalPage++;
	}
		
	private void calculatePage() {
		firstPage=((curPage-1)/pageLimit)*pageLimit+1;
		lastPage=firstPage+pageLimit-1;
		
		if(lastPage>totalPage)
			lastPage=totalPage;
	}
	
	private void calculateContent() {
		firstContent=(curPage-1)*contentLimit;
	}
	
	private void visiblePrev() {
		if(firstPage==1)
			prevButton=false;
	}
	
	private void visibleNext() {
		if(lastPage==totalPage)
			nextButton=false;
	}


	public int getTotalContent() {
		return totalContent;
	}

	public void setTotalContent(int totalContent) {
		this.totalContent = totalContent;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getContentLimit() {
		return contentLimit;
	}

	public void setContentLimit(int contentLimit) {
		this.contentLimit = contentLimit;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getFirstContent() {
		return firstContent;
	}
	
	public boolean isPrevButton() {
		return prevButton;
	}
	public boolean isNextButton() {
		return nextButton;
	}
	
}
