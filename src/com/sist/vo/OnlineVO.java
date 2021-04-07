package com.sist.vo;

/*
 * C_NO        NOT NULL NUMBER         
C_TITLE              VARCHAR2(2000) 
C_CONTENT            CLOB           
C_POSTER             VARCHAR2(4000) 
C_ARTIST             VARCHAR2(2000) 
C_PRICE              VARCHAR2(2000) 
C_ADDRESS            VARCHAR2(400)  
C_TIME               VARCHAR2(30)   
C_ONOFF              NUMBER         
C_CATEGORY           VARCHAR2(2000) 
C_INTRO              VARCHAR2(100)  
C_SUBTITLES          VARCHAR2(2000) 
C_CONTENTS           CLOB           
INFOADDR             VARCHAR2(50)  
C_SCORE              NUMBER(2,1)  
 * c_no, c_title, c_artist, c_price, c_onoff, c_poster, c_content
 */
public class OnlineVO {
	private int cno,wno;
	private double cscore;
	private String ctitle, cartist, cprice, cposter, ccontent;

	public double getCscore() {
		return cscore;
	}

	public void setCscore(double cscore) {
		this.cscore = cscore;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCartist() {
		return cartist;
	}

	public void setCartist(String cartist) {
		this.cartist = cartist;
	}

	public String getCprice() {
		return cprice;
	}

	public void setCprice(String cprice) {
		this.cprice = cprice;
	}

	public String getCposter() {
		return cposter;
	}

	public void setCposter(String cposter) {
		this.cposter = cposter;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

}
