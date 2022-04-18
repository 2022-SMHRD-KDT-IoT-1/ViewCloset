package com_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m_id = request.getParameter("login_id");
		String m_pw = request.getParameter("login_pw");
		
		System.out.println("»Æ¿Œ : " + m_id + "/" + m_pw);
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.login(new MemberVO(m_id, m_pw));
		
		response.setContentType("text/plain; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(vo != null) {
			System.out.println(vo.getM_nick());
			out.print(vo.getM_nick());
		}else {
			out.print("null");
		}
		
	}

}
