package com.pos.app.dto;

import java.io.Serializable;

public class FoodDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String food;

	private Integer totalPrice;

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public FoodDetailsDto(String food, Integer totalPrice) {
		super();
		this.food = food;
		this.totalPrice = totalPrice;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FoodSaleReportDto) {
			FoodDetailsDto foodDto =  (FoodDetailsDto)obj;
			if(food!=null && this.food.equals(foodDto.getFood()) && this.totalPrice.equals(foodDto.getTotalPrice())) {
				return true;
			}
		}
		return false;
	}

}
