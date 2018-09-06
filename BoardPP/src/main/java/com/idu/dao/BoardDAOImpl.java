package com.idu.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.idu.domain.BoardVO;
import com.idu.domain.SearchVO;


@Repository
public class BoardDAOImpl implements BoardDAO  {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.idu.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> selectBoardList(Map<String,Object> listMap) throws Exception {
		
		return sqlSession.selectList(namespace+".selectBoardList",listMap); //�씪�떒 �럹�씠吏� �븯湲곗쟾源뚯�
	}

	@Override
	public BoardVO readContent(Integer bno) throws Exception {
		
		return sqlSession.selectOne(namespace+".readContent",bno);
	}

	@Override
	public void writeContent(BoardVO vo) throws Exception {
		
		sqlSession.insert(namespace+".writeContent",vo);

	}

	@Override
	public void updateContent(BoardVO vo) throws Exception {
		
		sqlSession.update(namespace+".updateContent",vo);

	}

	@Override
	public void deleteContent(Integer bno) throws Exception {
		
		sqlSession.delete(namespace+".deleteContent",bno);

	}
	
	@Override
	public boolean pwCheck(Integer bno,String bpw) throws Exception {
		
		return sqlSession.selectOne(namespace+".pwCheck", bno) == bpw;
	}
	
	@Override
	public void increaseCnt(Integer bno)throws Exception {
		
		sqlSession.update(namespace+".increaseCnt", bno);
		
	}
	@Override
	public int countContent(SearchVO search){
		
		return sqlSession.selectOne(namespace+".countContent",search);
		
	}
}
