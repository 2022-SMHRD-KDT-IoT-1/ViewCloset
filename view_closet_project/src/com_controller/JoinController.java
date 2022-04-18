package com_controller;

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
		
		// data값 가져오기
		String m_id = request.getParameter("join_id");
		String m_pw = request.getParameter("join_pw");
		String m_nick = request.getParameter("join_nick");
		String m_phone = request.getParameter("join_phone");
		String m_gender = request.getParameter("join_gender");
		String m_height = request.getParameter("join_height");
		String m_weight = request.getParameter("join_weight");
		
		System.out.println("확인 : " + "id:" + m_id + "/" + "pw:" + m_pw + "/" + "nick:" + m_nick + "phone:" + m_phone + "/" + m_gender + "/" + m_height + "/" + m_weight);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.insert(new MemberVO(m_id, m_pw, m_phone, m_gender, m_nick, m_height, m_weight));
		
		PrintWriter out = response.getWriter();
		
		if(cnt > 0) {
			out.print("1");
		}else {
			out.print("0");
		}
		
	}

}
