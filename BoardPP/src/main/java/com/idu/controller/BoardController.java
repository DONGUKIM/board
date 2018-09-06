package com.idu.controller;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idu.domain.BoardVO;
import com.idu.domain.SearchVO;
import com.idu.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardServiceImpl bService;
	
	@RequestMapping("list") //regdate 포멧 해서 출력하기
	public void boardList(@RequestParam(defaultValue="1")int page,SearchVO search,Model model) throws Exception {
		
		List<BoardVO> bList = bService.listPage(page,search);
		model.addAttribute("bList",bList);
		model.addAttribute("page", bService.createPageVO(page,search));
		model.addAttribute("search",search);
				
	}
	@RequestMapping("read") // 해당 bno이 없을때(입력x/초과된 값) 경고 메세지와 함께 list 페이지로 리다이렉트 
	public String boardReadPage(@RequestParam("bno") Integer bno,@RequestParam(value="page", required=false, defaultValue="1")int curPage,Model model) throws Exception{
	
		if(bno==null||bno<1 )
		return "board/list";
		
		model.addAttribute("board",bService.read(bno));
		model.addAttribute("page", curPage);
		return "board/read";
	
	}
	//패스워드 저장도 구현
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String boardWritePage(@RequestParam(value="page", required=false, defaultValue="1")int curPage, Model model) {
		
		model.addAttribute("page", curPage);
				
		return "board/writePage";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String boardWrite(BoardVO vo,@RequestParam(value="page", required=false, defaultValue="1")int curPage,RedirectAttributes rttr) throws Exception {
		
		bService.write(vo);
		rttr.addAttribute("page",curPage);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String boardModifyPage(@RequestParam("bno") Integer bno,@RequestParam(value="page", required=false, defaultValue="1")int curPage,Model model) throws Exception {
		
		model.addAttribute("board",bService.read(bno)); // 더좋은 방식 찾기
		model.addAttribute("page", curPage);
		
		return "board/modifyPage";
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String boardModify(BoardVO vo, @RequestParam(value="page", required=false, defaultValue="1")int curPage,RedirectAttributes rttr) throws Exception {
		
		bService.modify(vo);
		
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page",curPage);
		return "redirect:/board/read";
	}
	
	@RequestMapping(value="remove")
	public String boardModifyPage(@RequestParam("bno") Integer bno,@RequestParam(value="page", required=false, defaultValue="1")int curPage,RedirectAttributes rttr) throws Exception {
		
		bService.remove(bno);
		rttr.addAttribute("page",curPage);
		
		return "redirect:/board/list";
	}
}
