package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.board.entity.Board;
import kr.board.entity.Inquiry;

// DAO -> @Mapper(생략가능)
@Mapper
public interface InquiryMapper {
	// Connection? SqlSessionFactory? - xml파일에서 연동 진행
	 // 구현은 api가 해줌, 추상메소드
	public List<Inquiry> inquiryList();
	
	public Inquiry inquiryContent(int idx);
	
	
}
