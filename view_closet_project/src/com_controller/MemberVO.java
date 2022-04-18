package com_controller;

public class MemberVO {

	private String m_id;
	private String m_pw;
	private String m_phone;
	private String m_gender;
	private String m_nick;
	private String m_height;
	private String m_weight;
	
	
	public MemberVO(String m_id, String m_pw, String m_nick, String m_gender, String m_phone, String m_height,
			String m_weight) {
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nick = m_nick;
		this.m_gender = m_gender;
		this.m_phone = m_phone;
		this.m_height = m_height;
		this.m_weight = m_weight;
	}
	
	
	public MemberVO(String m_id, String m_pw) {
		this.m_id = m_id;
		this.m_pw = m_pw;
	}


	public MemberVO(String m_id, String m_pw, String m_nick) {
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nick = m_nick;
	}


	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	
	public String getM_height() {
		return m_height;
	}
	public void setM_height(String m_height) {
		this.m_height = m_height;
	}
	
	public String getM_weight() {
		return m_weight;
	}
	public void setM_weight(String m_weight) {
		this.m_weight = m_weight;
	}
	
}
