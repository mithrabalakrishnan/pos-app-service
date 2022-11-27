package com.pos.app.dto;

import java.io.Serializable;

public class FoodUpdate implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer foodId;
	
	private Integer userId;
	
	private String status;
	
	public FoodUpdate() {
		
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
