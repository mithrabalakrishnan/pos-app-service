package com.pos.app.service;

import com.pos.app.dto.TableDTO;
import com.pos.app.vo.MenuDetails;

public interface UserHomeService {
	
	public MenuDetails getMenuDetails();
	
	
	public TableDTO tableBooking(TableDTO tableDto);
	

}
