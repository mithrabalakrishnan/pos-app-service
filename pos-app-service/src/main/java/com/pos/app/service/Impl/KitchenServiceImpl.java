package com.pos.app.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.app.dto.FoodUpdate;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.FoodOrder;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.service.KitchenService;

@Service
public class KitchenServiceImpl implements KitchenService {

	Logger logger = LoggerFactory.getLogger(KitchenServiceImpl.class);

	@Autowired
	private FoodOrderRepository orderRepository;

	@Override
	public List<FoodOrder> getOrderList() {
		logger.info("inside getOrderList()  in KitchenServiceImpl");

		List<FoodOrder> foodOrder = new ArrayList<>();

		try {

			foodOrder = orderRepository.findAll();

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return foodOrder;

	}

	@Override
	public FoodOrder updateOrderList(FoodUpdate update) {
		
		logger.info("inside getOrderList()  in KitchenServiceImpl");
		
		FoodOrder order = new FoodOrder();
		
		try {
			
			order = orderRepository.findByFoodIdAndUserId(update.getFoodId(),update.getUserId());
			
			order.setStatus(update.getStatus());
			
			orderRepository.save(order);
			
			
		}catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return order;
	}

}
