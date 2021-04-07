package com.sist.vo;

import java.util.Date;


	/*
	 * 	NO      NOT NULL NUMBER       
		CNO              NUMBER       
		ID               VARCHAR2(34) 
		NAME    NOT NULL VARCHAR2(34) 
		MSG     NOT NULL CLOB         
		REGDATE          DATE 
	 */
	public class WorkReplyVO {
		private int no;
		private int cno;
		private String id;
		private String name;
		private String msg;
		private Date regdate;
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
		

	}

