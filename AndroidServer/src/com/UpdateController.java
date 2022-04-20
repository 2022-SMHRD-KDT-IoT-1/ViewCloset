package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
//	this.m_id = m_id;
//	this.m_pw = m_pw;
//	this.m_phone = m_phone;
//	this.m_gender = m_gender;
//	this.m_nick = m_nick;
//	this.m_height = m_height;
//	this.m_weight = m_weight;
	
	
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String m_pw = request.getParameter("update_pw");
		String m_nick = request.getParameter("update_nick");
		String m_gender = request.getParameter("update_gender");
		String m_phone = request.getParameter("update_phone");
		String m_height = request.getParameter("update_height");
		String m_weight = request.getParameter("update_weight");
		String m_id = request.getParameter("update_id");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(new MemberVO(m_id,m_pw, m_phone, m_gender, m_nick, m_height, m_weight));
		
		
		System.out.println(cnt);
		
		PrintWriter out = response.getWriter();
		
		System.out.println("업데이트 구문 : "+m_pw+"/"+m_nick+"/"+m_id +"/"+m_weight);
		
		
		if (cnt>0) {
			out.print("1");
		}else {
			out.print("0");
		}
		
	}

}
