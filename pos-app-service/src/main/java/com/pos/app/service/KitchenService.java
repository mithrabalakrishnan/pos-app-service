package com.pos.app.service;

import java.util.List;

import com.pos.app.dto.FoodUpdate;
import com.pos.app.model.FoodOrder;

public interface KitchenService {
	
	public List<FoodOrder> getOrderList(); 
	
	public FoodOrder updateOrderList(FoodUpdate update);
	
	

}
