package com.pos.app.service;

import java.util.List;

import com.pos.app.dto.FoodDTO;
import com.pos.app.dto.FoodSaleReportDto;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.ReportDataDto;
import com.pos.app.dto.WeeklyReportDto;
import com.pos.app.model.Food;
import com.pos.app.model.UserDTO;
import com.pos.app.model.VoucherRequest;
import com.pos.app.vo.StatusResponse;

public interface AdminService {

	public Food addMenu(FoodDTO food);

	public OrderDetailsDto getOrderList();

	public ReportDataDto getMonthlyReport();

	public FoodSaleReportDto getMonthlyFoodReport();

	public List<Food> getFoodAllDetails();

	public List<Integer> getReportFoodItemMonthly(Integer foodId);

	public ReportDataDto getWeeklyReport(List<String> dateList);

	public FoodSaleReportDto getWeeklyFoodReport(List<String> dateList);

	public List<Integer> getReportFoodItemWeekly(WeeklyReportDto reportData);

	public StatusResponse kichenUser(UserDTO user);
	
	public StatusResponse waiterUser(UserDTO user);

	public StatusResponse addNewVoucher(VoucherRequest voucher);

	public StatusResponse deleteVoucher(Integer voucherId);

	public StatusResponse getVoucherDetails(Integer voucherId);

	public StatusResponse getAllVoucher();

	public StatusResponse getMonthlyUserReport();
	
	public StatusResponse getCustomerReport(String month);
}
