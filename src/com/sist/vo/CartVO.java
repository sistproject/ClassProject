package com.sist.vo;

/*
 *  ID      VARCHAR2(34) 
	C_NO    NUMBER       
	W_NO    NUMBER  
 * 
 */
public class CartVO {
	private String id;
	private int cno, wno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getWno() {
		return wno;
	}

	public void setWno(int wno) {
		this.wno = wno;
	}
}
