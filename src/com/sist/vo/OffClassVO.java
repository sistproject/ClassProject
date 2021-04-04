package com.sist.vo;

/*
 *  C_NO        NOT NULL NUMBER        
	C_TITLE              VARCHAR2(300) 
	C_CONTENT            CLOB          
	C_POSTER             VARCHAR2(500) 
	C_ARTIST             VARCHAR2(100) 
	C_PRICE              VARCHAR2(20)  
	C_ADDRESS            VARCHAR2(400) 
	C_TIME               VARCHAR2(30)  
	C_ONOFF              NUMBER        
	C_CATEGORY           VARCHAR2(50)  
	C_INTRO              VARCHAR2(100) 
	C_SUBTITLES          VARCHAR2(200) 
	C_CONTENTS           CLOB          
 */
public class OffClassVO {
	private int cno, conoff;
	private String ctitle, ccontent, cposter, cartist, cprice, caddress, ctime, ccategory, cintro, csubtitles,
			ccontents;

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getConoff() {
		return conoff;
	}

	public void setConoff(int conoff) {
		this.conoff = conoff;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCposter() {
		return cposter;
	}

	public void setCposter(String cposter) {
		this.cposter = cposter;
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

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCcategory() {
		return ccategory;
	}

	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	public String getCintro() {
		return cintro;
	}

	public void setCintro(String cintro) {
		this.cintro = cintro;
	}

	public String getCsubtitles() {
		return csubtitles;
	}

	public void setCsubtitles(String csubtitles) {
		this.csubtitles = csubtitles;
	}

	public String getCcontents() {
		return ccontents;
	}

	public void setCcontents(String ccontents) {
		this.ccontents = ccontents;
	}

}
