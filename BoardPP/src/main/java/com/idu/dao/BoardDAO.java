package com.idu.dao;

import java.util.List;
import java.util.Map;

import com.idu.domain.BoardVO;
import com.idu.domain.SearchVO;


public interface BoardDAO {
	
	public List<BoardVO> selectBoardList(Map<String,Object> listMap)throws Exception;
	public BoardVO readContent(Integer bno)throws Exception;
	public void writeContent(BoardVO vo)throws Exception;
	public void updateContent(BoardVO vo)throws Exception; 
	public void deleteContent(Integer bno)throws Exception;
	public boolean pwCheck(Integer bno,String bpw)throws Exception;
	public void increaseCnt(Integer bno)throws Exception;
	public int countContent(SearchVO search);
}
