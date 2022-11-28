package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

import com.pos.app.model.FoodOrder;
import com.pos.app.model.TableDetail;

public class OrderDetailsDto implements Serializable {

	private static final long serialVersionUID = 9197653270441373672L;

	private List<FoodOrder> orderList;
	
	private List<FoodUpdateOrderDTO> foodOrderList;
	

	private List<TableDetail> tableList;


	public List<FoodOrder> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<FoodOrder> orderList) {
		this.orderList = orderList;
	}


	public List<FoodUpdateOrderDTO> getFoodOrderList() {
		return foodOrderList;
	}


	public void setFoodOrderList(List<FoodUpdateOrderDTO> foodOrderList) {
		this.foodOrderList = foodOrderList;
	}


	public List<TableDetail> getTableList() {
		return tableList;
	}


	public void setTableList(List<TableDetail> tableList) {
		this.tableList = tableList;
	}

	public OrderDetailsDto() {
		// TODO Auto-generated constructor stub
	}


	public OrderDetailsDto(List<FoodOrder> orderList, List<FoodUpdateOrderDTO> foodOrderList,
			List<TableDetail> tableList) {
		super();
		this.orderList = orderList;
		this.foodOrderList = foodOrderList;
		this.tableList = tableList;
	}
	
	
}
