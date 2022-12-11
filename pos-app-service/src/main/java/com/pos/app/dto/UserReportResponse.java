package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

import com.pos.app.model.UserReport;

public class UserReportResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UserReport> userReport;

	private Integer totalUser;

	public List<UserReport> getUserReport() {
		return userReport;
	}

	public void setUserReport(List<UserReport> userReport) {
		this.userReport = userReport;
	}

	public Integer getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(Integer totalUser) {
		this.totalUser = totalUser;
	}

}
