package com.pos.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tableid;

	@Column
	private Integer userid;

	@Column
	private String date;

	@Column
	private String time;

	@Column
	private String members;

	@Column
	private String seatLocation;

	public TableDetail() {

	}

	public TableDetail(Integer tableid, Integer userid, String date, String time, String members, String seatLocation) {
		super();
		this.tableid = tableid;
		this.userid = userid;
		this.date = date;
		this.time = time;
		this.members = members;
		this.seatLocation = seatLocation;
	}

	

	public Integer getTableid() {
		return tableid;
	}

	public void setTableid(Integer tableid) {
		this.tableid = tableid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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
