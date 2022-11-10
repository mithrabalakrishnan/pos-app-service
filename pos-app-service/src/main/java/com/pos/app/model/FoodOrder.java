package com.pos.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodOrder {
	
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
	private String timeDate;

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

	public String getTimeDate() {
		return timeDate;
	}

	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}

	public FoodOrder(Integer id, Integer userId, Integer foodId, Integer quanty, Integer tableId, Integer totalPrice,
			String timeDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.foodId = foodId;
		this.quanty = quanty;
		this.tableId = tableId;
		this.totalPrice = totalPrice;
		this.timeDate = timeDate;
	}
	
	
	
}
