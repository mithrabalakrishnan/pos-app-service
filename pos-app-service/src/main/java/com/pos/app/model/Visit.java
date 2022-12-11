package com.pos.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity 
public class Visit implements Serializable{

	private static final long serialVersionUID = 2010723612128382081L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer visitid;
	
	@Column
	private Integer userid;
	
	@Column
	private String month;
	
	@Column
	private String date;
	
	public Visit() {
		// TODO Auto-generated constructor stub
	}

	public Integer getVisitid() {
		return visitid;
	}

	public void setVisitid(Integer visitid) {
		this.visitid = visitid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Visit(Integer visitid, Integer userid, String month, String date) {
		super();
		this.visitid = visitid;
		this.userid = userid;
		this.month = month;
		this.date = date;
	}

	
	
}
