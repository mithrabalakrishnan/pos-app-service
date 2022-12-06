package com.pos.app.model;

import java.io.Serializable;
import java.util.List;

public class FoodOrderResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private FoodOrder foodOrder;
	
	
	private List<String> phone;


	public FoodOrder getFoodOrder() {
		return foodOrder;
	}


	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}


	public List<String> getPhone() {
		return phone;
	}


	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	
	
	
}
