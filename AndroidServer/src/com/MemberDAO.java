package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class MemberDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	int cnt = 0;
	MemberVO vo = null;
	
	// 데이터베이스에 연결되는 메소드
	public void getCon() {
		
		try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url = "jdbc:oracle:thin:@localhost:1521:xe";
	         String dbid = "hr";
	         String dbpw = "hr";
	         
	         //2) 연결객체(Connection 객체)
	         conn = DriverManager.getConnection(url,dbid, dbpw);
	         
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
			String sql = "insert into tbl_memberInfo values(?,?,?,?,?,?,?,sysdate)";
			
			psmt = conn.prepareStatement(sql);
			
//			psmt.setString(1, vo.getId());
//			psmt.setString(2, vo.getPw());
//			psmt.setString(3, vo.getNick());
			psmt.setString(1, vo.getM_id());
			psmt.setString(2, vo.getM_pw());
			psmt.setString(3, vo.getM_phone());
			psmt.setString(4, vo.getM_gender());
			psmt.setString(5, vo.getM_nick());
			psmt.setString(6, vo.getM_weight());
			psmt.setString(7, vo.getM_height());
			
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
				String m_nick = rs.getString(5);
				
				System.out.println(m_nick);
				
				vo = new MemberVO(m_id,m_pw,m_nick);
				
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
	
	
	public int check(MemberVO vo) {
		getCon();
		
		try {
			String sql = "select * from tbl_memberInfo where m_id=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,  vo.getM_id());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String m_id = rs.getString(1);
				
//				vo = new MemberVO(m_id);
				cnt = 1;		
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;

	}
	
	public int update(MemberVO vo) {
		getCon();
		
		try {
			String sql = "update tbl_memberInfo set m_pw=?,m_phone=?,m_gender=?,m_nick=?,m_height=?,m_weight=?,m_joindate=sysdate where m_id=?";
			
			psmt = conn.prepareStatement(sql);
			
			
			System.out.println("pw : "+vo.getM_pw() +"nick : " +vo.getM_nick() +"gender : "+ vo.getM_gender() +"phone : "+ vo.getM_phone() +"height : "+ vo.getM_height() +"weight : "+ vo.getM_weight() +"id : "+ vo.getM_id());
			
			
			
			psmt.setString(1, vo.getM_pw());
			psmt.setString(2, vo.getM_nick());
			psmt.setString(3, vo.getM_gender());
			psmt.setString(4, vo.getM_phone());
			psmt.setString(5, vo.getM_height());
			psmt.setString(6, vo.getM_weight());
			psmt.setString(7, vo.getM_id());
			
			cnt = psmt.executeUpdate();
			
			System.out.println("확인 : " + cnt);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
	}
	
	
}
