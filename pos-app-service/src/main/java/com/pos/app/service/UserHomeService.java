package com.pos.app.service;

import com.pos.app.dto.FoodCategory;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.TableDTO;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.FoodOrderDTO;
import com.pos.app.model.FoodOrderResponse;
import com.pos.app.model.TableDetail;
import com.pos.app.model.User;
import com.pos.app.model.UserDTO;
import com.pos.app.vo.MenuDetails;
import com.pos.app.vo.StatusResponse;

public interface UserHomeService {

	public MenuDetails getMenuDetails();

	public TableDetail tableBooking(TableDTO tableDto);

	public FoodOrderResponse foodOder(FoodOrderDTO oderDto);

	public OrderDetailsDto getHistory();
	
	public FoodCategory getFoodCategory(); 
	
	
	public Food getCategoryDetails(String category);
	
	public User getUserProfile();
	
	public Food getDetailFoodCategory(String category);

	public StatusResponse updateProfile(UserDTO user);
	
	

}
