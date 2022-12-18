package com.pos.app.service;

import java.util.List;

import com.pos.app.dto.FoodUpdateOrderDTO;

public interface WaiterService {
	
	public List<FoodUpdateOrderDTO> getCompletedOrderList();

}
