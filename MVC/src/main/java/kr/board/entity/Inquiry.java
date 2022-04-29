package kr.board.entity;

public class Inquiry {
	private int idx;
	private String in_check;
	private String in_other;
	private String in_content;
	private String in_email;
	private String in_date;
	
	
	public String getIn_content() {
		return in_content;
	}
	public void setIn_content(String in_content) {
		this.in_content = in_content;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getIn_check() {
		return in_check;
	}
	public void setIn_check(String in_check) {
		this.in_check = in_check;
	}
	public String getIn_other() {
		return in_other;
	}
	public void setIn_other(String in_other) {
		this.in_other = in_other;
	}
	public String getIn_email() {
		return in_email;
	}
	public void setIn_email(String in_email) {
		this.in_email = in_email;
	}
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}


}
