package com_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com_controller.MemberVO;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	int cnt;
	MemberVO vo = null;
	
	public void getCon() {
		
		try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url = "jdbc:oracle:thin:@localhost:1521:xe";
	         String dbid = "hr";
	         String dbpw = "hr";
	         
	         //2) 연결객체(Connection 객체)
	         conn = DriverManager.getConnection(url,dbid, dbpw);
	         
	         if(conn != null) {
	        	 System.out.println("통신성공");
	         }else {
	        	 System.out.println("통신실패");
	         }
	         
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	   }
	
	public void close() {
        try {
           if(rs != null) {
           rs.close();
           }
           if(psmt != null) psmt.close();
           if(conn != null) conn.close();
        } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
     
  }

	public int insert(MemberVO vo) {
		getCon();
		
		try {
			String sql = "insert into tbl_memberInfo values(?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getM_id());
			psmt.setString(2, vo.getM_pw());
			psmt.setString(3, vo.getM_phone());
			psmt.setString(4, vo.getM_gender());
			psmt.setString(5, vo.getM_nick());
			psmt.setString(6, vo.getM_height());
			psmt.setString(7, vo.getM_weight());
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return cnt;
	}

	public MemberVO login(MemberVO vo) {
		getCon();
		
		try {
			String sql = "select * from tbl_memberInfo where m_id=? and m_pw=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getM_id());
			psmt.setString(2, vo.getM_pw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String m_id = rs.getString(1);
				String m_pw = rs.getString(2);
				String m_nick = rs.getString(3);
				
				vo = new MemberVO(m_id, m_pw, m_nick);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return vo;
	}

	public MemberVO delete(MemberVO vo) {
		getCon();
		
		try {
			String sql = "delete from tbl_memberInfo where m_id=? and m_pw=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getM_id());
			psmt.setString(2, vo.getM_pw());

			rs = psmt.executeQuery();

//			if (rs.next()) {
//				String m_id = rs.getString(1);
//				String m_pw = rs.getString(2);
//				
//				vo = new MemberVO(m_id, m_pw);
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return vo;
	}
	
	
	

}
