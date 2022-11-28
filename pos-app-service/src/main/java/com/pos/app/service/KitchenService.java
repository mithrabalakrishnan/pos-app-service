package com.pos.app.service;

import java.util.List;

import com.pos.app.dto.FoodUpdate;
import com.pos.app.dto.FoodUpdateOrderDTO;
import com.pos.app.model.FoodOrder;

public interface KitchenService {
	
	public List<FoodUpdateOrderDTO> getOrderList(); 
	
	public FoodOrder updateOrderList(FoodUpdate update);
	
	

}
