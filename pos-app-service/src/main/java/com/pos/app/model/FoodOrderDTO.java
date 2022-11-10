package com.pos.app.model;

import java.io.Serializable;
import java.util.List;

public class FoodOrderDTO implements Serializable{

	private static final long serialVersionUID = 2521139005567372056L;

	private List<Integer> foodId;
	
	private Integer quanty;
	
	private Integer tableId;
	
	private Integer totalPrice;
	
	private String timeDate;
	
	
	public FoodOrderDTO() {
		
	}


	public List<Integer> getFoodId() {
		return foodId;
	}


	public void setFoodId(List<Integer> foodId) {
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


	public String getTimeDate() {
		return timeDate;
	}


	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}


	public FoodOrderDTO(List<Integer> foodId, Integer quanty, Integer tableId, Integer totalPrice, String timeDate) {
		super();
		this.foodId = foodId;
		this.quanty = quanty;
		this.tableId = tableId;
		this.totalPrice = totalPrice;
		this.timeDate = timeDate;
	}
	
	

}
