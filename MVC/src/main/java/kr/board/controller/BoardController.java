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
import kr.board.mapper.BoardMapper;

@Controller // POJO라고 인식
public class BoardController {
	// boardList.do --> Method boardList()
	// 메모리에 올라간 Mapper인터페이스를 가져옴
	@Autowired //DI(의존성 주입)
	private BoardMapper boardMapper;
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		/*
		 * Board vo = new Board(); vo.setIdx(1); vo.setTitle("게시판연습");
		 * vo.setContent("게시판연습"); vo.setWriter("관리자"); vo.setIndate("2022-03-18");
		 * vo.setCount(0); List<Board> list = new ArrayList<Board>(); list.add(vo);
		 * list.add(vo); list.add(vo);
		 */
		List<Board> list = boardMapper.boardList();
		// !!객체바인딩!! request객체 필요(스프링은 model사용)
		model.addAttribute("list", list);
		return "boardList"; // WEB-INF/views/boardList.jsp
	}
	// boardInsert.do --> Method boardInsert()
	@RequestMapping("/boardInsertForm.do")
	public String boardInsertForm() {
		return "boardInsertForm"; //boardInsertForm.jsp로 이동
		//void 해도 됨, 디폴트 경로로 넘어감
	}
	@RequestMapping("/boardInsert.do")
	public String boardInsert(Board vo) { //디폴트 생성자가 알아서 생성됨
		boardMapper.boardInsert(vo); // title, content, writer -> 파라미터수집
		return "redirect:/boardList.do"; //Controller로 이동(jsp가 아니라)
	}
	@RequestMapping("/boardContent.do/{idx}") //?idx=${vo.idx}
	public String boardContent(@PathVariable("idx") int idx, Model model) { //넘어오는 idx값을 담아줌
		//@RequestParam("idx") int 새로운변수 도 가능
		//@PathVariable을 통해 파라미터를 유용하게 사용도 가능
		Board vo = boardMapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardContent"; //jsp로 이동
	}
	@RequestMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		boardMapper.boardDelete(idx);
		return "redirect:/boardList.do"; //controller로 이동
	}
	@RequestMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {
		Board vo = boardMapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdateForm";
	}
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) { //idx, title, content
		boardMapper.boardUpdate(vo);
		return "redirect:/boardList.do";
	}
}
