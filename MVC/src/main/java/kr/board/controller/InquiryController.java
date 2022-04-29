package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.entity.Inquiry;
import kr.board.mapper.BoardMapper;
import kr.board.mapper.InquiryMapper;

@Controller // POJO라고 인식
public class InquiryController {
	// boardList.do --> Method boardList()
	// 메모리에 올라간 Mapper인터페이스를 가져옴
	
	@Autowired //DI(의존성 주입)
	private InquiryMapper inquiryMapper;
	
	@RequestMapping("/inquiryList.do")
	public String inquiryList(Model model) {
		/*
		 * Board vo = new Board(); vo.setIdx(1); vo.setTitle("게시판연습");
		 * vo.setContent("게시판연습"); vo.setWriter("관리자"); vo.setIndate("2022-03-18");
		 * vo.setCount(0); List<Board> list = new ArrayList<Board>(); list.add(vo);
		 * list.add(vo); list.add(vo);
		 */
		List<Inquiry> list = inquiryMapper.inquiryList();
		// !!객체바인딩!! request객체 필요(스프링은 model사용)
		model.addAttribute("list", list);
		return "inquiryList"; // WEB-INF/views/boardList.jsp
	}
	@RequestMapping("/inquiryContent.do/{idx}") //?idx=${vo.idx}
	public String inquiryContent(@PathVariable("idx") int idx, Model model) { //넘어오는 idx값을 담아줌
		//@RequestParam("idx") int 새로운변수 도 가능
		//@PathVariable을 통해 파라미터를 유용하게 사용도 가능
		Inquiry vo = inquiryMapper.inquiryContent(idx);
		model.addAttribute("vo", vo);
		return "inquiryContent"; //jsp로 이동
	}
	
}