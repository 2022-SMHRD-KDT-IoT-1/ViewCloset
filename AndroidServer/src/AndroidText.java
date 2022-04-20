

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AndroidText")
public class AndroidText extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// 요청이 들어오는지 확인 할 수 있는 출력문 만들기
//		System.out.println("서버에 요청이 들어왔습니다!");
//		
//		// 인코딩 문제 해결하기
//		response.setCharacterEncoding("EUC-KR");
//		
//		// App에 보내줄 인코딩 작업 진행
//		response.setContentType("EUC-KR");
//		
//		// 웹 페이지에 띄워줄 내용 작성
//		PrintWriter out = response.getWriter();
//		
////		out.print("응답 성공!");
//		
//		// JSON 타입의 응답값 만들기
//		out.print("{\"name\":\"김민선\"}");
		
		String data = request.getParameter("data");
		System.out.println("전달 받은 데이터 : " + data);
		
	}

}
