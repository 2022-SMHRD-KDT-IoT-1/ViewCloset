package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// App에서 전달해주는 3개의 정보 가져와서 변수에 저장하기
		// id, pw, nick
		String m_id = request.getParameter("join_id");
		// String m_id = "id1";
		String m_pw = request.getParameter("join_pw");
		// String m_pw = "pw1";
		String m_phone = request.getParameter("join_phone");
		// String m_phone = "phone1";
		String m_gender = request.getParameter("join_gender");
		// String m_gender = "gender1";
		String m_nick = request.getParameter("join_nick");
		// String m_nick = "nick1";
		String m_height = request.getParameter("join_height");
		// String m_height = "height1";
		String m_weight = request.getParameter("join_weight");
		// String m_weight = "weight1";
		System.out.println("확인 : " + m_id + "/" + m_pw + "/" + m_nick +"/"+m_phone+"/"+m_height+"/"+m_weight+"/"+m_gender);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.insert(new MemberVO(m_id, m_pw, m_phone, m_gender, m_nick, m_height, m_weight));
		
		PrintWriter out = response.getWriter();
		
		if(cnt > 0) {	// 회원가입 성공
			out.print("1");
		}else {
			out.print("0");
		}
		
	}

}
