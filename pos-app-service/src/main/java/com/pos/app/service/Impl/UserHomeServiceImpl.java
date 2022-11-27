package com.pos.app.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pos.app.dto.FoodCategory;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.TableDTO;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.FoodOrderDTO;
import com.pos.app.model.TableDetail;
import com.pos.app.model.User;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserBookingRepository;
import com.pos.app.repository.UserRepository;
import com.pos.app.service.UserHomeService;
import com.pos.app.util.DateUtil;
import com.pos.app.vo.MenuDetails;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
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
	public MenuDetails getMenuDetails() throws BusinessException {
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
	public TableDetail tableBooking(TableDTO tableDto) throws BusinessException {
		logger.info("inside tableBooking() in UserHomeServiceImpl");

		TableDetail details = new TableDetail();

		try {

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			TableDetail tableDetail = bookingRepository.findByTimeAndDate(tableDto.getTime(), tableDto.getDate());

			if (tableDetail != null) {
				logger.info("table already booked in UserHomeServiceImpl");
				throw new BusinessException("This table already booked on this time.");
			}

			User user = userRepository.findByUsername(username);

			details.setUserId((int) user.getId());
			details.setDate(tableDto.getDate());
			details.setTime(tableDto.getTime());
			details.setMembers(tableDto.getMembers());
			details.setSeatLocation(tableDto.getSeatLocation());

			bookingRepository.save(details);

		} catch (Exception e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return details;
	}

	@Override
	public FoodOrder foodOder(FoodOrderDTO oderDto) throws BusinessException {
		logger.info("inside foodOder() in UserHomeServiceImpl");

		FoodOrder order = new FoodOrder();

		try {

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			User user = userRepository.findByUsername(username);

			order.setUserId((int) user.getId());

			order.setTableId(oderDto.getTableId());
			order.setDate(oderDto.getDate());
			order.setTime(oderDto.getTime());
			order.setDay(DateUtil.getDay(oderDto.getDate()));
			order.setMonth(DateUtil.getMonth(oderDto.getDate()));
			order.setYear(DateUtil.getYear(oderDto.getDate()));

			for (int i = 0; i < oderDto.getFoodId().size(); i++) {
				order.setFoodId(oderDto.getFoodId().get(i));
				order.setQuanty(oderDto.getQuanty().get(i));
				order.setTotalPrice(oderDto.getTotalPrice().get(i));
				orderRepository.save(order);
			}

		} catch (BusinessException e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return order;
	}

	@Override
	public OrderDetailsDto getHistory() throws BusinessException {

		logger.info("inside getHistory() in UserHomeServiceImpl");

		OrderDetailsDto details = new OrderDetailsDto();

		try {

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			User user = userRepository.findByUsername(username);

			Integer userId = (int) user.getId();

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

	@Override
	public FoodCategory getFoodCategory() {
		logger.info("inside getFoodCategory() in UserHomeServiceImpl");

		FoodCategory foodCategory = new FoodCategory();

		try {

			//List<String> category = adminRepository.findByCategory();

		//	foodCategory.setFoodCategory(category);

		} catch (Exception e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return foodCategory;
	}

	@Override
	public Food getCategoryDetails(String category) {
		logger.info("inside getCategoryDetails() in UserHomeServiceImpl");
		
		Food food = new Food();
		
		try {
			
			food = adminRepository.findByCategory(category);
			
			
		} catch (Exception e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return null;
	}

}
