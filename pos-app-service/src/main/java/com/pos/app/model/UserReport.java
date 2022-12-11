package com.pos.app.model;

import java.io.Serializable;
import java.util.List;

public class UserReport implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private Integer visitList;
	
	private Integer totalUser;

	public UserReport() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getVisitList() {
		return visitList;
	}

	public void setVisitList(Integer visitList) {
		this.visitList = visitList;
	}

	public UserReport(String username, Integer visitList) {
		super();
		this.username = username;
		this.visitList = visitList;
	}

	public Integer getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(Integer totalUser) {
		this.totalUser = totalUser;
	}
	
	
}
