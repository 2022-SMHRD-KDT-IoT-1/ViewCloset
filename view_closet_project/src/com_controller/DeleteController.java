package com_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m_id = request.getParameter("edt_delete_id");
		String m_pw = request.getParameter("edt_delete_pw");
		
		System.out.println("확인 :" + m_id + "/" + m_pw);
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.delete(new MemberVO(m_id, m_pw));
		
		response.setContentType("text/plain; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(vo != null) {
			System.out.println("회원 삭제 성공");
		}else {
			System.out.println("회원 삭제 실패");
		}
		
	}

}
