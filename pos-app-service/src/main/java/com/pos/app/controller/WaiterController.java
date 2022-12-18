package com.pos.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.app.constants.AppConstants;
import com.pos.app.dto.FoodUpdateOrderDTO;
import com.pos.app.service.WaiterService;
import com.pos.app.vo.StatusResponse;

@RestController
public class WaiterController {
	
	private Logger logger = LoggerFactory.getLogger(WaiterController.class);
	
	@Autowired
	private WaiterService waiterService;
	
	@GetMapping("/completed-order")
	public ResponseEntity<?> getCompletedOrderList() {
		logger.info("inside getCompletedOrderList() in WaiterController");

		List<FoodUpdateOrderDTO> orders = waiterService.getCompletedOrderList();
		StatusResponse response = new StatusResponse();
		response.setData(orders);
		response.setStatus(AppConstants.STATUS_SUCCESS);
		response.setMessage("Order Details");
		return ResponseEntity.ok(response);

	}

}
