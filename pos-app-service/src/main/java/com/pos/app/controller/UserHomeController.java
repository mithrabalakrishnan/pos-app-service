package com.pos.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos.app.constants.AppConstants;
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
import com.pos.app.service.UserHomeService;
import com.pos.app.vo.MenuDetails;
import com.pos.app.vo.StatusResponse;

@RestController
public class UserHomeController {

	private Logger logger = LoggerFactory.getLogger(UserHomeController.class);

	@Autowired
	private UserHomeService userHomeService;

	@GetMapping("/user-home")
	public ResponseEntity<?> getUserHome() {
		logger.info("inside getUserHome() in UserHomeController");

		MenuDetails menu = userHomeService.getMenuDetails();
		StatusResponse response = new StatusResponse();
		response.setData(menu);
		response.setStatus(AppConstants.STATUS_SUCCESS);
		response.setMessage("User Home Details");
		return ResponseEntity.ok(response);

	}
	
	@PostMapping("/table-booking")
	public ResponseEntity<?> tableBooking(@RequestBody TableDTO tableDto){
		
		logger.info("inside tableBooking() in UserHomeController ");
		
		TableDetail table = userHomeService.tableBooking(tableDto);
		
		StatusResponse response = new StatusResponse();
		response.setData(table);
		response.setMessage("Table Booked");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/food-order")
	public ResponseEntity<?> foodOdering( @RequestBody FoodOrderDTO orderDto){
		logger.info("inside foodOdering() in UserHomeController ");
		
		FoodOrderResponse  order = userHomeService.foodOder(orderDto);
		
		StatusResponse response = new StatusResponse();
		response.setData(order);
		response.setMessage("Food Ordered");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/user-history")
	public ResponseEntity<?> getHistory(){
		
		logger.info("inside getHistory() in UserHomeController ");
		
		OrderDetailsDto history = userHomeService.getHistory();
		
		StatusResponse response = new StatusResponse();
		response.setData(history);
		response.setMessage("History details");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/food-category")
	public ResponseEntity<?> getFoodCategory(){
		
		logger.info("inside getFoodCategory() in UserHomeController ");
		
		FoodCategory category = userHomeService.getFoodCategory();
		
		StatusResponse response = new StatusResponse();
		response.setData(category);
		response.setMessage("Food Category");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/category-detail")
	public ResponseEntity<?> getCategoryDetails(@RequestParam String category){
		
		logger.info("inside getCategoryDetails() in UserHomeController ");
		
		List<Food> food = userHomeService.getDetailsFoodCategory(category);
		
		StatusResponse response = new StatusResponse();
		response.setData(food);
		response.setMessage("Food Category");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/user-profile")
	public ResponseEntity<?> getUserProfile(){
		
		logger.info("inside getUserProfile() in UserHomeController ");
		
		User user = userHomeService.getUserProfile();
		
		StatusResponse response = new StatusResponse();
		response.setData(user);
		response.setMessage("Food Category");
		response.setStatus(AppConstants.STATUS_SUCCESS);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/update-profile")
	public ResponseEntity<?> updateProfile(@RequestBody UserDTO user){
		return ResponseEntity.ok(userHomeService.updateProfile(user));
	}

}
