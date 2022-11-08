package com.pos.app.dto;

import java.io.Serializable;

public class TableDTO implements Serializable {

	private static final long serialVersionUID = 1179612767379337844L;

	private String date;

	private String time;

	private String members;

	private String seatLocation;

	public TableDTO() {

	}

	public TableDTO(String date, String time, String members, String seatLocation) {
		super();
		this.date = date;
		this.time = time;
		this.members = members;
		this.seatLocation = seatLocation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getSeatLocation() {
		return seatLocation;
	}

	public void setSeatLocation(String seatLocation) {
		this.seatLocation = seatLocation;
	}

}
