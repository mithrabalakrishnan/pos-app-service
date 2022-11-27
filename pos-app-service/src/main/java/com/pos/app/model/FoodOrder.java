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
	private Integer id;
	
	@Column
	private Integer userId;
	
	@Column
	private Integer foodId;
	
	@Column
	private Integer quanty;
	
	@Column
	private Integer tableId;
	
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

	public FoodOrder(Integer id, Integer userId, Integer foodId, Integer quanty, Integer tableId, Integer totalPrice,
			String date, String time, Integer day, String month, Integer year) {
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
	}

	
	
	
}
