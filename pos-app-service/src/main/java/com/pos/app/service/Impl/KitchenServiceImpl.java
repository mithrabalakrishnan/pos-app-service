package com.pos.app.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.app.dto.FoodUpdate;
import com.pos.app.dto.FoodUpdateOrderDTO;
import com.pos.app.exception.BusinessException;
import com.pos.app.mapper.FoodOrderMapper;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.User;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserRepository;
import com.pos.app.service.KitchenService;

@Service
public class KitchenServiceImpl implements KitchenService {

	Logger logger = LoggerFactory.getLogger(KitchenServiceImpl.class);

	@Autowired
	private FoodOrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
//	@Autowired
//	private FoodOrderMapper foodMapper;

	@Override
	public List<FoodUpdateOrderDTO> getOrderList() {
		logger.info("inside getOrderList()  in KitchenServiceImpl");

		List<FoodOrder> foodOrder = new ArrayList<>();
		
		List<FoodUpdateOrderDTO> foodOrderList = new ArrayList<FoodUpdateOrderDTO>();
		
		try {

			foodOrder = orderRepository.findAll();
			
			for(int i=0;i<foodOrder.size();i++) {
				
				Food food = adminRepository.findByFoodid(foodOrder.get(i).getFoodid());
				User user = userRepository.findByUserid(foodOrder.get(i).getUserid());
				
				
				FoodUpdateOrderDTO foodUpdate = new FoodUpdateOrderDTO();
				foodUpdate.setId(foodOrder.get(i).getOrderId());
				foodUpdate.setFoodId(foodOrder.get(i).getFoodid());
				foodUpdate.setUserId(foodOrder.get(i).getUserid());
				foodUpdate.setDate(foodOrder.get(i).getDate());
				foodUpdate.setTime(foodOrder.get(i).getTime());
				foodUpdate.setFoodName(food.getFood_name());
				foodUpdate.setUsername(user.getUsername());
				foodUpdate.setQuanty(foodOrder.get(i).getQuanty());
				foodUpdate.setStatus(foodOrder.get(i).getStatus());
				foodUpdate.setTableId(foodOrder.get(i).getTableId());
				
				foodOrderList.add(foodUpdate);
				
				
			}

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return foodOrderList;

	}

	@Override
	public FoodOrder updateOrderList(FoodUpdate update) {
		
		logger.info("inside getOrderList()  in KitchenServiceImpl");
		
		FoodOrder order = new FoodOrder();
		
		try {
			
		//	order = orderRepository.findByFoodIdAndUserId(update.getFoodId(),update.getUserId());
			
			order.setStatus(update.getStatus());
			
			//orderRepository.save(order);
			
			
		}catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return order;
	}

}
