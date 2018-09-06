package com.idu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.idu.dao.BoardDAO;
import com.idu.domain.BoardVO;
import com.idu.domain.PageVO;
import com.idu.domain.SearchVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> listPage(int curPage, SearchVO search) throws Exception {
		
		Map<String,Object> listMap = new HashMap<String,Object>();
		listMap.put("page", createPageVO(curPage,search));
		listMap.put("search", search);
		
		return dao.selectBoardList(listMap);
	}
	
	@Override
	public PageVO createPageVO(int curPage,SearchVO search) {
		
		int totalContent=dao.countContent(search);
		PageVO page = new PageVO(curPage,totalContent);
		
		return page;
		
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception { //트랜젝션 처리 필요
		
		dao.increaseCnt(bno);
		return dao.readContent(bno);
	}

	@Override
	public void write(BoardVO vo) throws Exception {
		dao.writeContent(vo);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.updateContent(vo);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.deleteContent(bno);
	}

}
