package com.pos.app.controller;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.app.constants.AppConstants;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.service.KitchenService;
import com.pos.app.vo.MenuDetails;
import com.pos.app.vo.StatusResponse;

@RestController
public class KitchenController {
	
	@Autowired
	private KitchenService kitchenService;
	
	private Logger logger = LoggerFactory.getLogger(KitchenController.class);
	
	@GetMapping("/kitchen-order")
	public ResponseEntity<?> getOrderList() {
		logger.info("inside getOrderList() in KitchenController");

		List<FoodOrder> orders = kitchenService.getOrderList();
		StatusResponse response = new StatusResponse();
		response.setData(orders);
		response.setStatus(AppConstants.STATUS_SUCCESS);
		response.setMessage("User Home Details");
		return ResponseEntity.ok(response);

	}
	
	@Update("/kitchen-order")
	public ResponseEntity<?> updateOrder(@RequestBody Food odd) {
		
		logger.info("inside updateOrder() in KitchenController");

		List<FoodOrder> orders = kitchenService.getOrderList();
		StatusResponse response = new StatusResponse();
		response.setData(orders);
		response.setStatus(AppConstants.STATUS_SUCCESS);
		response.setMessage("User Home Details");
		return ResponseEntity.ok(response);

	}

}
