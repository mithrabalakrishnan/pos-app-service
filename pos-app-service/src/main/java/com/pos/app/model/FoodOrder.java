package com.pos.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodOrder {
	
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderid;
	
	@Column
	private Integer userid;
	
	@Column
	private Integer foodid;
	
	@Column
	private Integer quanty;
	
	@Column
	private Integer tableid;
	
	@Column
	private Integer totalPrice;
	

	@Column
	private String date;
	
	@Column
	private String time;
	
	@Column
	private Integer day;
	
	@Column
	private String month;
	
	@Column
	private Integer year;
	
	@Column
	private String status;
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FoodOrder() {
		
	}

	

	

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getFoodid() {
		return foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	public Integer getQuanty() {
		return quanty;
	}

	public void setQuanty(Integer quanty) {
		this.quanty = quanty;
	}

	

	public Integer getTableid() {
		return tableid;
	}

	public void setTableid(Integer tableid) {
		this.tableid = tableid;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public FoodOrder(Integer orderid, Integer userid, Integer foodid, Integer quanty, Integer tableid, Integer totalPrice,
			String date, String time, Integer day, String month, Integer year) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.foodid = foodid;
		this.quanty = quanty;
		this.tableid = tableid;
		this.totalPrice = totalPrice;
		this.date = date;
		this.time = time;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	
	
	
}
