package com.pos.app.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.app.dto.FoodUpdateOrderDTO;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.User;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserRepository;
import com.pos.app.service.WaiterService;

@Service
public class WaiterServiceImpl implements WaiterService{
	
	Logger logger = LoggerFactory.getLogger(WaiterServiceImpl.class);
	
	@Autowired
	private FoodOrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<FoodUpdateOrderDTO> getCompletedOrderList() {
		logger.info("inside getCompletedOrderList()  in WaiterServiceImpl");

		List<FoodOrder> foodOrder = new ArrayList<>();
		
		List<FoodUpdateOrderDTO> foodOrderList = new ArrayList<FoodUpdateOrderDTO>();
		
		try {

			foodOrder = orderRepository.findByStatus("Completed");
			
			for(int i=0;i<foodOrder.size();i++) {
				
				Food food = adminRepository.findByFoodid(foodOrder.get(i).getFoodid());
				User user = userRepository.findByUserid(foodOrder.get(i).getUserid());
				
				
				FoodUpdateOrderDTO foodUpdate = new FoodUpdateOrderDTO();
				foodUpdate.setId(foodOrder.get(i).getOrderid());
				foodUpdate.setFoodId(foodOrder.get(i).getFoodid());
				foodUpdate.setUserId(foodOrder.get(i).getUserid());
				foodUpdate.setDate(foodOrder.get(i).getDate());
				foodUpdate.setTime(foodOrder.get(i).getTime());
				foodUpdate.setFoodName(food.getFood_name());
				foodUpdate.setUsername(user.getUsername());
				foodUpdate.setIncrediance(food.getIncrediance());
				foodUpdate.setUserPhoneNumber(user.getPhone_no());
				foodUpdate.setQuanty(foodOrder.get(i).getQuanty());
				foodUpdate.setStatus(foodOrder.get(i).getStatus());
				foodUpdate.setTableId(foodOrder.get(i).getTableid());
				
				foodOrderList.add(foodUpdate);
				
				
			}

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return foodOrderList;
	}

}
