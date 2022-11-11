package com.pos.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.TableDTO;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.FoodOrderDTO;
import com.pos.app.model.TableDetail;
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
		response.setStatus(true);
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
		response.setStatus(true);
		
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/food-order")
	public ResponseEntity<?> foodOdering( @RequestBody FoodOrderDTO orderDto){
		logger.info("inside foodOdering() in UserHomeController ");
		
		FoodOrder order = userHomeService.foodOder(orderDto);
		
		StatusResponse response = new StatusResponse();
		response.setData(order);
		response.setMessage("Food Ordered");
		response.setStatus(true);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/user-history")
	public ResponseEntity<?> getHistory(){
		
		logger.info("inside getHistory() in UserHomeController ");
		
		OrderDetailsDto history = userHomeService.getHistory();
		
		StatusResponse response = new StatusResponse();
		response.setData(history);
		response.setMessage("History details");
		response.setStatus(true);
		
		return ResponseEntity.ok(response);
	}

}
