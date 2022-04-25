package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.board.entity.Board;

// DAO -> @Mapper(생략가능)
@Mapper
public interface BoardMapper {
	// Connection? SqlSessionFactory? - xml파일에서 연동 진행
	public List<Board> boardList(); // 구현은 api가 해줌, 추상메소드
	public void boardInsert(Board vo);
	public Board boardContent(int idx);
	@Delete("delete from board where idx=#{idx}")
	public void boardDelete(int idx); //Mapper에 안 만들고 바로 
	public void boardUpdate(Board vo);
	
}
