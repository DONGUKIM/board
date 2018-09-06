package com.idu.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.idu.dao.BoardDAO;
import com.idu.domain.BoardVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	/*@Test
	public void testInsertBoard()throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setContent("새로운 글 내용");
		vo.setTitle("새로운 글 제목");
		vo.setWriter("작성자");
		
		dao.writeContent(vo);
	}
	*/
	@Test
	public void testReadBoard()throws Exception{
	
	     dao.readContent(3);
	}
	
	@Test
	public void testUpdateBoard()throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setBno(3);
		vo.setContent("수정한 글 내용");
		vo.setTitle("수정한 글 제목");
		vo.setWriter("수정작성자");
				
		dao.updateContent(vo);
	}
	
	//@Test
	//public void testDeleteBoard()throws Exception{
	
	//     dao.deleteContent(4);
	//}
	
	
	
}
