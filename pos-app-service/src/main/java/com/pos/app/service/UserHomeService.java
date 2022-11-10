package com.pos.app.service;

import com.pos.app.dto.TableDTO;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.FoodOrderDTO;
import com.pos.app.model.TableDetail;
import com.pos.app.vo.MenuDetails;

public interface UserHomeService {
	
	public MenuDetails getMenuDetails();
	
	
	public TableDetail tableBooking(TableDTO tableDto);
	
	public FoodOrder foodOder(FoodOrderDTO oderDto);
	

}
