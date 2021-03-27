package com.sist.class_;
/*
C_NO      NOT NULL NUMBER         
C_TITLE            VARCHAR2(200)  
C_CONTENT          VARCHAR2(3000) 
C_POSTER           VARCHAR2(200)  
C_SUBJECT          VARCHAR2(40)   
C_ARTIST           VARCHAR2(20)   
C_LIKE             NUMBER         
C_HIT              NUMBER         
C_PRICE            VARCHAR2(20)   
C_REGDATE          DATE           
C_TERM             VARCHAR2(20)   
C_TARGET           VARCHAR2(200)  
C_SCORE            VARCHAR2(50)   
CAT1_NO            NUMBER         
C_ADDRESS          VARCHAR2(100)  
C_LEVEL            VARCHAR2(10)   
C_TIME             VARCHAR2(30)   
C_PERSON           VARCHAR2(30)   
C_MEMO             VARCHAR2(1000) 
C_TAG              VARCHAR2(30)   
C_CANCEL           VARCHAR2(1000) 
 * 
 */
public class ClassVO {
	private int cno, clike, chit, cat1no;
	private String ctitle, ccontent, cposter, csubject, cartist, cprice, cregdate, cterm, ctarget, cscore, caddress,clevel, ctime,
					cpersion,cmemo, ctag, ccancel;
}
