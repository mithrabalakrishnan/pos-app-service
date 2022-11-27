package com.pos.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos.app.constants.AppConstants;
import com.pos.app.dto.FoodDTO;
import com.pos.app.dto.FoodSaleReportDto;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.ReportDataDto;
import com.pos.app.model.Food;
import com.pos.app.service.AdminService;
import com.pos.app.vo.StatusResponse;

@RestController
public class AdminController {
	
	Logger logger =LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add-menu")
	public ResponseEntity<?> addMenu(@RequestBody FoodDTO food){
		
		logger.info("inside addMenu() in AdminController");
		
		Food menu = adminService.addMenu(food);
		
		StatusResponse response = new StatusResponse();
		response.setData(menu);
		response.setMessage("New Food Added");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/order-list")
	public ResponseEntity<?> getOrderList(){
		
		logger.info("inside getOrderList() in AdminController");
		
		OrderDetailsDto orderList = adminService.getOrderList();
		
		StatusResponse response = new StatusResponse();
		response.setData(orderList);
		response.setMessage("Order List");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/report-monthly")
	public ResponseEntity<?> getReportMonthly(){
		
		logger.info("inside getReportMonthly() in AdminController");
		
		ReportDataDto report = adminService.getMonthlyReport();
		
		StatusResponse response = new StatusResponse();
		response.setData(report);
		response.setMessage("Data fetched Successfully");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	
	
	@GetMapping("/report-food-sales-monthly")
	public ResponseEntity<?> getReportFoodMonthly(){
		
		logger.info("inside getReportFoodMonthly() in AdminController");
		
		FoodSaleReportDto report = adminService.getMonthlyFoodReport();
		
		StatusResponse response = new StatusResponse();
		response.setData(report);
		response.setMessage("Data fetched Successfully");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/report-food-item-monthly")
	public ResponseEntity<?> getReportFoodItemMonthly(@RequestParam Integer foodId){
		
		logger.info("inside getReportFoodItemMonthly() in AdminController");
		
		List<Integer> report = adminService.getReportFoodItemMonthly(foodId);
		
		StatusResponse response = new StatusResponse();
		response.setData(report);
		response.setMessage("Data fetched Successfully");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/food-details")
	public ResponseEntity<?> getFoodAllDeatils(){
		
		logger.info("inside getFoodAllDeatils() in AdminController");
		
		List<Food> food = adminService.getFoodAllDetails();
		
		StatusResponse response = new StatusResponse();
		response.setData(food);
		response.setMessage("Data fetched Successfully");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	

}
