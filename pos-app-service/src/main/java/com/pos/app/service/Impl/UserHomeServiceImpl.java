package com.pos.app.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.TableDTO;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.FoodOrderDTO;
import com.pos.app.model.TableDetail;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserBookingRepository;
import com.pos.app.repository.UserRepository;
import com.pos.app.service.UserHomeService;
import com.pos.app.vo.MenuDetails;

@Service
public class UserHomeServiceImpl implements UserHomeService {

	private Logger logger = LoggerFactory.getLogger(UserHomeServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserBookingRepository bookingRepository;

	@Autowired
	private FoodOrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public MenuDetails getMenuDetails() {
		logger.info("inside getMenuDetails() in UserHomeServiceImpl");
		MenuDetails details = new MenuDetails();
		try {

			List<Food> popular = adminRepository.findByStatus("popular");
			List<Food> recent = adminRepository.findByStatus("recent");

			details.setPopular_foods(popular);
			details.setRecent_foods(recent);
			details.setTop_offers(null);

		} catch (BusinessException e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return details;
	}

	@Override
	public TableDetail tableBooking(TableDTO tableDto) {
		logger.info("inside tableBooking() in UserHomeServiceImpl");

		TableDetail details = new TableDetail();

		try {

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			Integer userId = userRepository.getUserId(username);

			details.setUserId(userId);
			details.setDate(tableDto.getDate());
			details.setTime(tableDto.getTime());
			details.setMembers(tableDto.getMembers());
			details.setSeatLocation(tableDto.getSeatLocation());

			bookingRepository.save(details);

		} catch (BusinessException e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return details;
	}

	@Override
	public FoodOrder foodOder(FoodOrderDTO oderDto) {
		logger.info("inside foodOder() in UserHomeServiceImpl");

		FoodOrder order = new FoodOrder();

		try {

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			Integer userId = userRepository.getUserId(username);

			order.setUserId(userId);
			order.setQuanty(oderDto.getQuanty());
			order.setTableId(oderDto.getTableId());
			order.setTimeDate(oderDto.getTimeDate());
			order.setTotalPrice(oderDto.getTotalPrice());

			for (int i = 0; i < oderDto.getFoodId().size(); i++) {
				order.setFoodId(oderDto.getFoodId().get(i));
				orderRepository.save(order);
			}

		} catch (BusinessException e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return order;
	}

	@Override
	public OrderDetailsDto getHistory() {

		logger.info("inside getHistory() in UserHomeServiceImpl");

		OrderDetailsDto details = new OrderDetailsDto();

		try {

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			Integer userId = userRepository.getUserId(username);

			List<FoodOrder> orderList = orderRepository.findByUserId(userId);

			List<TableDetail> tableDetail = bookingRepository.findByUserId(userId);

			details.setOrderList(orderList);
			details.setTableList(tableDetail);

		} catch (BusinessException e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return details;
	}

}
