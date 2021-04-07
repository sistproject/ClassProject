package com.sist.vo;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReserveVO {
	private int no;
	private String id;
	private String title;
	private String day;
	private String time;
	private String inwon;
	private int state;
	private Date regdate;
	private String dbday;
}