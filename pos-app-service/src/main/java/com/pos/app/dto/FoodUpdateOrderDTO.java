package com.pos.app.dto;

import java.io.Serializable;

public class FoodUpdateOrderDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer userId;

	private Integer foodId;

	private Integer quanty;

	private Integer tableId;

	private Integer totalPrice;

	private String date;

	private String time;

	private Integer day;

	private String month;

	private Integer year;

	private String foodName;

	private String username;

	private String status;
	
	private String userPhoneNumber;
	
	public FoodUpdateOrderDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public FoodUpdateOrderDTO(Integer id, Integer userId, Integer foodId, Integer quanty, Integer tableId, Integer totalPrice,
			String date, String time, Integer day, String month, Integer year, String foodName, String username,
			String status,String userPhoneNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.foodId = foodId;
		this.quanty = quanty;
		this.tableId = tableId;
		this.totalPrice = totalPrice;
		this.date = date;
		this.time = time;
		this.day = day;
		this.month = month;
		this.year = year;
		this.foodName = foodName;
		this.username = username;
		this.status = status;
		this.userPhoneNumber= userPhoneNumber;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getQuanty() {
		return quanty;
	}

	public void setQuanty(Integer quanty) {
		this.quanty = quanty;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
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

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}



	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	
	

}
