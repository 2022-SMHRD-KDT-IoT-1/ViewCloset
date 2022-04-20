package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckController")
public class CheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m_id = request.getParameter("check_id");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.check(new MemberVO(m_id));
		
		PrintWriter out = response.getWriter();
		
		if (cnt > 0) {
			System.out.println(m_id);;
			
		}else {
			out.print("null");
		}
		
	}

}
