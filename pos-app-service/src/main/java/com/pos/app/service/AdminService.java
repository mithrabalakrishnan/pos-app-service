package com.pos.app.service;

import java.util.List;

import com.pos.app.dto.FoodDTO;
import com.pos.app.dto.FoodSaleReportDto;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.ReportDataDto;
import com.pos.app.model.Food;

public interface AdminService {
	
	public Food addMenu(FoodDTO food);
	
	public OrderDetailsDto getOrderList();
	
	public ReportDataDto getMonthlyReport();
	
	public FoodSaleReportDto getMonthlyFoodReport();
	
	public List<Food> getFoodAllDetails();
	
	public List<Integer> getReportFoodItemMonthly(Integer foodId);
}
