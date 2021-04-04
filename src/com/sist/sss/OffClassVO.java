package com.sist.sss;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class OffClassVO {	
	private int cno,conoff;
	private String ctitle,ccontent,cposter,cartist,cprice,caddress,ctime,
					ccategory,cintro,csubtitles,ccontents;

}
