package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

import com.pos.app.model.FoodOrder;
import com.pos.app.model.TableDetail;

public class OrderDetailsDto implements Serializable {

	private static final long serialVersionUID = 9197653270441373672L;

	private List<FoodOrder> orderList;

	private List<TableDetail> tableList;

	public OrderDetailsDto() {

	}

	public OrderDetailsDto(List<FoodOrder> orderList, List<TableDetail> tableList) {
		super();
		this.orderList = orderList;
		this.tableList = tableList;
	}

	public List<FoodOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<FoodOrder> orderList) {
		this.orderList = orderList;
	}

	public List<TableDetail> getTableList() {
		return tableList;
	}

	public void setTableList(List<TableDetail> tableList) {
		this.tableList = tableList;
	}

}
