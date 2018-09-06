package com.idu.service;

import java.util.List;

import com.idu.domain.BoardVO;
import com.idu.domain.PageVO;
import com.idu.domain.SearchVO;


public interface BoardService {
	
	public List<BoardVO> listPage (int curPage, SearchVO search) throws Exception;
	public PageVO createPageVO(int curPage, SearchVO sarch);
	public BoardVO read (Integer bno) throws Exception;
	public void write (BoardVO vo) throws Exception;
	public void modify (BoardVO vo) throws Exception;
	public void remove (Integer bno) throws Exception;

	
	
	

}
