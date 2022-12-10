package com.pos.app.model;

import java.io.Serializable;
import java.util.List;

public class UserReport implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private List<Integer> visitList;

	public UserReport() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Integer> getVisitList() {
		return visitList;
	}

	public void setVisitList(List<Integer> visitList) {
		this.visitList = visitList;
	}

	public UserReport(String username, List<Integer> visitList) {
		super();
		this.username = username;
		this.visitList = visitList;
	}

}
