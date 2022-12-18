package com.pos.app.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSInput;

import com.pos.app.constants.AppConstants;
import com.pos.app.dto.FoodCategory;
import com.pos.app.dto.FoodUpdateOrderDTO;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.TableDTO;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.FoodOrderDTO;
import com.pos.app.model.FoodOrderResponse;
import com.pos.app.model.TableDetail;
import com.pos.app.model.User;
import com.pos.app.model.UserDTO;
import com.pos.app.model.Visit;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserBookingRepository;
import com.pos.app.repository.UserRepository;
import com.pos.app.repository.UserVisitRepository;
import com.pos.app.service.UserHomeService;
import com.pos.app.util.DateUtil;
import com.pos.app.vo.MenuDetails;
import com.pos.app.vo.StatusResponse;

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
	
	@Autowired
	private UserVisitRepository userVisitRepository;

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

			TableDetail tableDetail = bookingRepository.findByTimeAndDateAndSeatLocation(tableDto.getTime(), tableDto.getDate(), tableDto.getSeatLocation());

			if (tableDetail != null) {
				logger.info("table already booked in UserHomeServiceImpl");
				throw new BusinessException("This table already booked on this time.");
			}

			User user = userRepository.findByUsername(username);

			details.setUserid(user.getUserid());
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
	public FoodOrderResponse foodOder(FoodOrderDTO oderDto) throws BusinessException {
		logger.info("inside foodOder() in UserHomeServiceImpl");

		FoodOrder order = new FoodOrder();
		FoodOrderResponse response = new FoodOrderResponse();

		try {

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			User user = userRepository.findByUsername(username);

			for (int i = 0; i < oderDto.getFoodId().size(); i++) {
				logger.info("inside foodOder() inside for loop UserHomeServiceImpl");
				order = new FoodOrder();
				order.setUserid(user.getUserid());

				order.setTableid(oderDto.getTableId());
				order.setDate(oderDto.getDate());
				order.setTime(oderDto.getTime());
				order.setDay(DateUtil.getDay(oderDto.getDate()));
				order.setMonth(DateUtil.getMonth(oderDto.getDate()));
				order.setYear(DateUtil.getYear(oderDto.getDate()));
				order.setFoodid(oderDto.getFoodId().get(i));
				order.setQuanty(oderDto.getQuanty().get(i));
				order.setTotalPrice(oderDto.getTotalPrice().get(i));
				order.setStatus("To Do");
				orderRepository.save(order);
			}
			
			
			Visit visit = new Visit();
			visit.setDate(oderDto.getDate());
			visit.setMonth(DateUtil.getMonth(oderDto.getDate()));
			visit.setUserid(user.getUserid());
			
			
			logger.info("inside foodOder() before visit save() UserHomeServiceImpl "+visit);
			
			userVisitRepository.save(visit);
			
			
			List<String> phone = new ArrayList<>();
			List<User> kichecUser = userRepository.findByRole(AppConstants.ROLE_KITCHEN);
			
			for(int j = 0; j<kichecUser.size();j++) {
				phone.add(kichecUser.get(j).getPhone_no());
			}
			
			response.setFoodOrder(order);
			response.setPhone(phone);
			//order.setKichen_phone(phone);

		} catch (BusinessException e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return response;
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

			Integer userId = user.getUserid();

			logger.info("inside getHistory() in UserHomeServiceImpl  uderid= " + userId);

			List<FoodOrder> orderList = orderRepository.findByUserid(userId);

			List<FoodUpdateOrderDTO> foodOrderList = getOrderList(orderList);

			List<TableDetail> tableDetail = bookingRepository.findByUserid(userId);

//			details.setOrderList(orderList);
			details.setFoodOrderList(foodOrderList);
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
			List<String> category = new ArrayList<>();
			List<Food> food = adminRepository.findAll();
			
			for(int i=0;i<food.size();i++) {
				category.add(food.get(i).getCategory());
			}
			
			//List<String> catg = removeDuplicate(category);
			
			foodCategory.setFoodCategory(removeDuplicate(category));
			// foodCategory.setFoodCategory(category);

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

		//	food = adminRepository.findByCategory(category);
			
			

		} catch (Exception e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return food;
	}

	public List<FoodUpdateOrderDTO> getOrderList(List<FoodOrder> foodOrder) {

		List<FoodUpdateOrderDTO> foodOrderList = new ArrayList<FoodUpdateOrderDTO>();

		for (int i = 0; i < foodOrder.size(); i++) {

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
			foodUpdate.setQuanty(foodOrder.get(i).getQuanty());
			foodUpdate.setStatus(foodOrder.get(i).getStatus());
			foodUpdate.setTableId(foodOrder.get(i).getTableid());
			foodUpdate.setTotalPrice(foodOrder.get(i).getTotalPrice());

			foodOrderList.add(foodUpdate);

		}

		return foodOrderList;

	}

	@Override
	public User getUserProfile() {
		
		logger.info("inside getUserProfile() in UserHomeServiceImpl");
		User user = new User();
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			user = userRepository.findByUsername(username);

		} catch (Exception e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return user;
	}
	
	@Override
	public List<Food> getDetailsFoodCategory(String category) {
		logger.info("inside getDetailFoodCategory() in UserHomeServiceImpl");
		
		List<Food> food = new ArrayList<>();
		try {
			food = adminRepository.findByCategory(category);
			
		} catch (Exception e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return food;
	}
	
	private static List<String> removeDuplicate(List<String> details) {
		List<String> newList = new ArrayList<String>();

		for (String value : details) {
			if (!newList.contains(value)) {
				newList.add(value);
			}
		}
		return newList;
	}
	
	@Override
	public StatusResponse updateProfile(UserDTO user) {
		logger.info("inside updateProfile() in UserHomeServiceImpl");
		StatusResponse response = new StatusResponse();
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();
			User updateUser = new User();
			updateUser = userRepository.findByUsername(username);
			
			updateUser.setEmail(user.getEmail());
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			updateUser.setPhone_no(user.getPhone());
			//updateUser.setUsername(user.getUsername());
		
			userRepository.save(updateUser);
			
			response.setData(updateUser);
			response.setMessage("User Updated");
			response.setStatus(AppConstants.STATUS_SUCCESS);
			
			
		} catch (Exception e) {
			logger.error("ERROR " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return response;
	}

	@Override
	public Food getDetailFoodCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
