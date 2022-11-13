package com.pos.app.model;

import java.io.Serializable;
import java.util.List;

public class FoodOrderDTO implements Serializable {

	private static final long serialVersionUID = 2521139005567372056L;

	private List<Integer> foodId;

	private List<Integer> quanty;

	private Integer tableId;

	private List<Integer> totalPrice;

	private String timeDate;

	public FoodOrderDTO() {

	}

	public List<Integer> getFoodId() {
		return foodId;
	}

	public void setFoodId(List<Integer> foodId) {
		this.foodId = foodId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getTimeDate() {
		return timeDate;
	}

	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}

	public List<Integer> getQuanty() {
		return quanty;
	}

	public void setQuanty(List<Integer> quanty) {
		this.quanty = quanty;
	}

	public List<Integer> getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(List<Integer> totalPrice) {
		this.totalPrice = totalPrice;
	}

	public FoodOrderDTO(List<Integer> foodId, List<Integer> quanty, Integer tableId, List<Integer> totalPrice,
			String timeDate) {
		super();
		this.foodId = foodId;
		this.quanty = quanty;
		this.tableId = tableId;
		this.totalPrice = totalPrice;
		this.timeDate = timeDate;
	}

}
