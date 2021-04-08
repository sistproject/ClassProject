package com.sist.vo;

import java.util.Date;

public class WorkReplyVO {
	private int no;   // 댓글 번호
	private int cno;
	private String id;
	private String name;
	private String msg;
	private Date regdate;
	private String dbday;
	private int w_no;

	public int getW_no() {
		return w_no;
	}

	public void setW_no(int w_no) {
		this.w_no = w_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getDbday() {
		return dbday;
	}

	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
}

