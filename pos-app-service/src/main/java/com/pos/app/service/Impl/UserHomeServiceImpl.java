package com.pos.app.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pos.app.dto.TableDTO;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.TableDetail;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.UserBookingRepository;
import com.pos.app.repository.UserRepository;
import com.pos.app.service.UserHomeService;
import com.pos.app.vo.MenuDetails;

@Service
public class UserHomeServiceImpl implements UserHomeService{

	private Logger logger = LoggerFactory.getLogger(UserHomeServiceImpl.class);
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserBookingRepository bookingRepository;
	
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
			logger.error("ERROR "+ e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		
		return details;
	}

	@Override
	public TableDTO tableBooking(TableDTO tableDto) {
		logger.info("inside tableBooking() in UserHomeServiceImpl");
		
		TableDetail  details = new TableDetail();
		
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
			logger.error("ERROR "+ e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		
		return tableDto;
	}
	

}
