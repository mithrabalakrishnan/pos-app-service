package com.pos.app.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.app.dto.FoodDTO;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.TableDetail;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserBookingRepository;
import com.pos.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserBookingRepository bookingRepository;

	@Autowired
	private FoodOrderRepository orderRepository;
	
	@Override
	public Food addMenu(FoodDTO food) throws BusinessException{

		logger.info("inside addMenu()  in AdminServiceImpl");

		Food newMenu = new Food();
		try {

			logger.info("before condition check --- AdminServiceImp");
			if (adminRepository.findByName(food.getName()) != null) {
				logger.info("food already found");
				throw new BusinessException("This food already added");
			}

			newMenu.setCategory(food.getCategory());
			newMenu.setName(food.getName());
			newMenu.setPrice(food.getPrice());
			newMenu.setRating(food.getRating());
			newMenu.setStatus(food.getStatus());
			newMenu.setImage(food.getImage());

			logger.info("before save() check --- AdminServiceImp");
			newMenu = adminRepository.save(newMenu);

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return newMenu;
	}

	@Override
	public OrderDetailsDto getOrderList() throws BusinessException{
		logger.info("inside getOrderList()  in AdminServiceImpl");
		
		OrderDetailsDto orderDetail = new OrderDetailsDto();
		
		try {
			
			List<TableDetail> tableDetails = bookingRepository.findAll();
			
			List<FoodOrder> foodOrder = orderRepository.findAll();
			
			orderDetail.setOrderList(foodOrder);
			orderDetail.setTableList(tableDetails);
			

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return orderDetail;
	}

}
