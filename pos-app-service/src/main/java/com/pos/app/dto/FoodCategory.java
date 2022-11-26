package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

public class FoodCategory implements Serializable {

	private static final long serialVersionUID = -7706813790831306179L;

	List<String> foodCategory;

	public FoodCategory() {

	}

	public List<String> getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(List<String> foodCategory) {
		this.foodCategory = foodCategory;
	}

}
