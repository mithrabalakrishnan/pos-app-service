package com.pos.app.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pos.app.constants.AppConstants;
import com.pos.app.dto.FoodDTO;
import com.pos.app.dto.FoodDetailsDto;
import com.pos.app.dto.FoodSaleReportDto;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.ReportDataDto;
import com.pos.app.dto.UserReportResponse;
import com.pos.app.dto.WeeklyReportDto;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.TableDetail;
import com.pos.app.model.User;
import com.pos.app.model.UserDTO;
import com.pos.app.model.UserReport;
import com.pos.app.model.Visit;
import com.pos.app.model.Voucher;
import com.pos.app.model.VoucherRequest;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserBookingRepository;
import com.pos.app.repository.UserRepository;
import com.pos.app.repository.UserVisitRepository;
import com.pos.app.repository.VoucherRepository;
import com.pos.app.service.AdminService;
import com.pos.app.vo.StatusResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class AdminServiceImpl implements AdminService {

	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserBookingRepository bookingRepository;

	@Autowired
	private FoodOrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private VoucherRepository voucherRepository;
	
	@Autowired
	private UserVisitRepository visitRepository;

	@Override
	public Food addMenu(FoodDTO food) throws BusinessException {

		logger.info("inside addMenu()  in AdminServiceImpl");

		Food newMenu = new Food();
		try {

			logger.info("before condition check --- AdminServiceImp");
//			if (adminRepository.findByfoodName(food.getName()) != null) {
//				logger.info("food already found");
//				throw new BusinessException("This food already added");
//			}

			newMenu.setCategory(food.getCategory());
			newMenu.setFood_name(food.getName());
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
	public OrderDetailsDto getOrderList() throws BusinessException {
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

	@Override
	public ReportDataDto getMonthlyReport() {
		logger.info("inside getMonthlyReport()  in AdminServiceImpl");

		ReportDataDto report = new ReportDataDto();
		try {

			List<Integer> monthAmount = new ArrayList<Integer>();
			List<Integer> customerList = new ArrayList<Integer>();
			for (int i = 1; i <= 12; i++) {

				if (i == 1) {

					List<FoodOrder> oder = orderRepository.findByMonth("JANUARY");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Jan  in AdminServiceImpl");

				if (i == 2) {

					List<FoodOrder> oder = orderRepository.findByMonth("FEBRUARY");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Feb  in AdminServiceImpl");

				if (i == 3) {

					List<FoodOrder> oder = orderRepository.findByMonth("MARCH");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Mar  in AdminServiceImpl");

				if (i == 4) {

					List<FoodOrder> oder = orderRepository.findByMonth("APRIL");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after April  in AdminServiceImpl");

				if (i == 5) {

					List<FoodOrder> oder = orderRepository.findByMonth("MAY");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after May  in AdminServiceImpl");

				if (i == 6) {

					List<FoodOrder> oder = orderRepository.findByMonth("JUNE");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Jun  in AdminServiceImpl");

				if (i == 7) {

					List<FoodOrder> oder = orderRepository.findByMonth("JULY");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after July  in AdminServiceImpl");

				if (i == 8) {

					List<FoodOrder> oder = orderRepository.findByMonth("AUGUST");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Aug  in AdminServiceImpl");

				if (i == 9) {

					List<FoodOrder> oder = orderRepository.findByMonth("SEPTEMBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Sep  in AdminServiceImpl");

				if (i == 10) {

					List<FoodOrder> oder = orderRepository.findByMonth("OCTOBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Oct  in AdminServiceImpl");

				if (i == 11) {

					List<FoodOrder> oder = orderRepository.findByMonth("NOVEMBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Nov  in AdminServiceImpl");

				if (i == 12) {

					List<FoodOrder> oder = orderRepository.findByMonth("DECEMBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(j).getUserid());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Dec  in AdminServiceImpl");

			}

			int totals = 0;

			for (int i = 0; i < monthAmount.size(); i++) {
				totals += monthAmount.get(i);
			}

			List<Integer> custList = removeDuplicate(customerList);

			report.setChart_data(monthAmount);
			report.setTotal_customers(custList.size());
			report.setType("Monthly");
			report.setTotal_sale(totals);

			logger.info("inside getMonthlyReport() Report data generated  in AdminServiceImpl");

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());

		}
		return report;
	}

	private static List<Integer> removeDuplicate(List<Integer> details) {
		List<Integer> newList = new ArrayList<Integer>();

		for (Integer value : details) {
			if (!newList.contains(value)) {
				newList.add(value);
			}
		}
		return newList;
	}

	@Override
	public FoodSaleReportDto getMonthlyFoodReport() {

		logger.info("inside getMonthlyFoodReport()  in AdminServiceImpl");

		FoodSaleReportDto sales = new FoodSaleReportDto();

		try {
			List<FoodDetailsDto> foodDetails = new ArrayList<>();

			List<Integer> priceList = new ArrayList<Integer>();

			for (int i = 1; i <= 12; i++) {

				if (i == 1) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("JANUARY", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}
				logger.info("inside getMonthlyFoodReport() after jan  in AdminServiceImpl");

				if (i == 2) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("FEBRUARY",
								food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after Feb  in AdminServiceImpl");

				if (i == 3) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("MARCH", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after March  in AdminServiceImpl");

				if (i == 4) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("APRIL", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after Feb  in AdminServiceImpl");

				if (i == 5) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("MAY", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after Feb  in AdminServiceImpl");

				if (i == 6) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("JUNE", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after JUNE  in AdminServiceImpl");

				if (i == 7) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("JULY", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after JULY  in AdminServiceImpl");

				if (i == 8) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("AUGUST", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);
					}
				}

				logger.info("inside getMonthlyFoodReport() after AUGUST  in AdminServiceImpl");

				if (i == 9) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("SEPTEMBER",
								food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);
					}
				}

				logger.info("inside getMonthlyFoodReport() after SEPTEMBER  in AdminServiceImpl");

				if (i == 10) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("OCTOBER", food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);
					}
				}

				logger.info("inside getMonthlyFoodReport() after OCTOBER  in AdminServiceImpl");

				if (i == 11) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("NOVEMBER",
								food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after NOVEMBER  in AdminServiceImpl");

				if (i == 12) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("DECEMBER",
								food.get(j).getFoodid());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getFood_name(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);
					}
				}

				logger.info("inside getMonthlyFoodReport() after DECEMBER  in AdminServiceImpl");

				sales.setChart_data(priceList);
				sales.setFood_details(foodDetails);
				sales.setType("Monthly");

				logger.info("inside getMonthlyFoodReport() sales Report  in AdminServiceImpl");

			}

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return sales;
	}

	@Override
	public List<Food> getFoodAllDetails() {

		logger.info("inside getFoodAllDetails()  in AdminServiceImpl");

		List<Food> food = new ArrayList<>();

		try {

			food = adminRepository.findAll();

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return food;
	}

	@Override
	public List<Integer> getReportFoodItemMonthly(Integer foodId) {

		logger.info("inside getReportFoodItemMonthly()  in AdminServiceImpl");

		List<Integer> chart_data = new ArrayList<Integer>();

		try {

			for (int i = 1; i <= 12; i++) {

				if (i == 1) {

					Integer foodPrice = 0;
					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("JANUARY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 2) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("FEBRUARY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 3) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("MARCH", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 4) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("APRIL", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 5) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("MAY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 6) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("JUNE", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 7) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("JULY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 8) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("AUGUST", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 9) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("SEPTEMBER", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 10) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("OCTOBER", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 11) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("NOVEMBER", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 12) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodid("DECEMBER", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

			}

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return chart_data;

	}

	@Override
	public ReportDataDto getWeeklyReport(List<String> dateList) {

		logger.info("inside getWeeklyReport()  in AdminServiceImpl");

		ReportDataDto reportData = new ReportDataDto();

		try {
			List<Integer> monthAmount = new ArrayList<Integer>();
			List<Integer> customerList = new ArrayList<Integer>();

			for (int i = 0; i < dateList.size(); i++) {

				List<FoodOrder> oder = orderRepository.findByDate(dateList.get(i));

				Integer totalPrice = 0;

				for (int j = 0; j < oder.size(); j++) {
					totalPrice += oder.get(j).getTotalPrice();
					customerList.add(oder.get(j).getUserid());
				}

				monthAmount.add(totalPrice);

			}

			logger.info("inside getWeeklyReport() getWeekly Report  in AdminServiceImpl");

			int totals = 0;

			for (int i = 0; i < monthAmount.size(); i++) {
				totals += monthAmount.get(i);
			}

			logger.info("inside getWeeklyReport() getWeekly Report before with duplicate  in AdminServiceImpl");

			List<Integer> custList = removeDuplicate(customerList);

			reportData.setChart_data(monthAmount);
			reportData.setTotal_customers(custList.size());
			reportData.setType("Weekly");
			reportData.setTotal_sale(totals);

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return reportData;
	}

	@Override
	public FoodSaleReportDto getWeeklyFoodReport(List<String> dateList) {
		logger.info("inside getWeeklyFoodReport()  in AdminServiceImpl");

		FoodSaleReportDto sales = new FoodSaleReportDto();

		try {

			List<FoodDetailsDto> foodDetails = new ArrayList<>();

			List<Integer> priceList = new ArrayList<Integer>();
			List<String> foodList = new ArrayList<String>();

			for (int i = 0; i < dateList.size(); i++) {

				List<Food> food = adminRepository.findAll();

				for (int j = 0; j < food.size(); j++) {
					Integer foodPrice = 0;
					List<FoodOrder> oder = orderRepository.findByDateAndFoodid(dateList.get(i),
							food.get(j).getFoodid());

					logger.info("inside getWeeklyFoodReport()  " + oder);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice = foodPrice + oder.get(k).getTotalPrice();
					}
					if (foodPrice != 0) {
						/*
						 * if(!foodDetails.contains(new FoodDetailsDto(food.get(j).getFood_name(),
						 * foodPrice))) { foodDetails.add(new FoodDetailsDto(food.get(j).getFood_name(),
						 * foodPrice)); }
						 * 
						 * if(!foodList.contains(food.get(j).getFood_name())){
						 * foodList.add(food.get(j).getFood_name()); }
						 */
						foodList.add(food.get(j).getFood_name());
						priceList.add(foodPrice);
					}

				}
			}

			sales.setFood_name_list(foodList);
			sales.setChart_data(priceList);
			sales.setFood_details(foodDetails);
			sales.setType("Weekly");

			logger.info("inside getWeeklyFoodReport() sales Report  in AdminServiceImpl");

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return sales;
	}

	@Override
	public List<Integer> getReportFoodItemWeekly(WeeklyReportDto reportData) {

		logger.info("inside getReportFoodItemWeekly()  in AdminServiceImpl");

		List<Integer> chart_data = new ArrayList<Integer>();

		try {

			List<String> dateList = reportData.getDateList();
			Integer foodId = reportData.getFoodId();

			for (int i = 0; i < dateList.size(); i++) {
				Integer foodPrice = 0;
				List<FoodOrder> oder = orderRepository.findByDateAndFoodid(dateList.get(i), foodId);

				for (int k = 0; k < oder.size(); k++) {
					foodPrice += oder.get(k).getTotalPrice();
				}
				chart_data.add(foodPrice);

			}

		} catch (BusinessException e) {
			logger.error("ERROR:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return chart_data;
	}

	@Override
	public StatusResponse kichenUser(UserDTO user) {
		StatusResponse response = new StatusResponse();
		User newUser = new User();

		try {
			logger.info("inside kichenUser()------ AdminServiceImpl class");

			newUser.setUsername(user.getUsername());
			newUser.setFirstName(user.getFirstName());
			newUser.setLastName(user.getLastName());
			newUser.setPhone_no(user.getPhone());
			newUser.setEmail(user.getEmail());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setRole(AppConstants.ROLE_KITCHEN);

			if (userRepository.findByEmail(newUser.getEmail()) != null) {
				logger.info("Email already registered");
				throw new BusinessException("Email already registered");
//			}else if(userRepository.findByPhone(newUser.getPhone_no())!=null) {
//				log.info("Phone already registered");
//				throw new BusinessException("Phone already registered");
			} else if (userRepository.findByUsername(newUser.getUsername()) != null) {
				logger.info("username already found");
				throw new BusinessException("username already found");
			}

			newUser = userRepository.save(newUser);
//			int result = userMapper.createUser(newUser);

			response.setStatus(AppConstants.STATUS_SUCCESS);
			response.setMessage("Kitchen User Registration Successfull");
			response.setData(newUser);

		} catch (BusinessException e) {
			logger.error("Error Message:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return response;
	}

	@Override
	public StatusResponse addNewVoucher(VoucherRequest voucher) {

		logger.info("inside addNewVoucher()------ AdminServiceImpl class");

		StatusResponse response = new StatusResponse();

		try {
			Voucher newVoucher = new Voucher();
			newVoucher.setVoucherTitle(voucher.getVoucherTitle());
			newVoucher.setVoucherCode(voucher.getVoucherCode());
			newVoucher.setDate(voucher.getDate());
			newVoucher.setVoucherDiscount(voucher.getVoucherDiscount());

			voucherRepository.save(newVoucher);
			response.setData(newVoucher);
			response.setMessage("New Voucher Added");
			response.setStatus(AppConstants.STATUS_SUCCESS);

			logger.info("inside addNewVoucher() after save()------ AdminServiceImpl class" + newVoucher);
		} catch (BusinessException e) {
			logger.error("Error Message:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return response;
	}

	@Override
	public StatusResponse deleteVoucher(Integer voucherId) {

		logger.info("inside deleteVoucher() ------ AdminServiceImpl class");

		StatusResponse response = new StatusResponse();

		try {

			voucherRepository.deleteByVoucherId(voucherId);
			response.setData(true);
			response.setMessage("Voucher Deleted");
			response.setStatus(AppConstants.STATUS_SUCCESS);

		} catch (BusinessException e) {
			logger.error("Error Message:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return response;
	}

	@Override
	public StatusResponse getAllVoucher() {

		StatusResponse response = new StatusResponse();
		logger.info("inside getAllVoucher() ------ AdminServiceImpl class");

		try {

			List<Voucher> allVoucher = voucherRepository.findAll();
			response.setData(allVoucher);
			response.setMessage("All Voucher Voucher ");
			response.setStatus(AppConstants.STATUS_SUCCESS);

		} catch (BusinessException e) {
			logger.error("Error Message:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return response;
	}

	@Override
	public StatusResponse getVoucherDetails(Integer voucherId) {
		StatusResponse response = new StatusResponse();
		logger.info("inside getAllVoucher() ------ AdminServiceImpl class");

		try {

			Voucher Voucher = voucherRepository.findByVoucherId(voucherId);
			response.setData(Voucher);
			response.setMessage("Voucher Details");
			response.setStatus(AppConstants.STATUS_SUCCESS);

		} catch (BusinessException e) {
			logger.error("Error Message:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return response;
	}

	@Override
	public StatusResponse getMonthlyUserReport() {
		StatusResponse response = new StatusResponse();
		logger.info("inside getMonthlyUserReport() ------ AdminServiceImpl class");

		try {

			List<User> allUser = userRepository.findAll();
			List<UserReport> userReport = new ArrayList<UserReport>();
			for (int j = 0; j < allUser.size(); j++) {
				List<FoodOrder> foodOrder = new ArrayList<>();
				List<Integer> visitList = new ArrayList<Integer>();
				User user = new User();
				for (int i = 0; i < 12; i++) {

					if (i == 0) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "JANUARY");
						visitList.add(foodOrder.size());
					}

					if (i == 1) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "FEBRUARY");
						visitList.add(foodOrder.size());
					}

					if (i == 2) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "MARCH");
						visitList.add(foodOrder.size());
					}
					if (i == 3) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "APRIL");
						visitList.add(foodOrder.size());
					}
					if (i == 4) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "MAY");
						visitList.add(foodOrder.size());
					}
					if (i == 5) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "JUNE");
						visitList.add(foodOrder.size());
					}
					if (i == 6) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "JULY");
						visitList.add(foodOrder.size());
					}
					if (i == 7) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "AUGUST");
						visitList.add(foodOrder.size());
					}
					if (i == 8) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "SEPTEMBER");
						visitList.add(foodOrder.size());
					}
					if (i == 9) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "OCTOBER");
						visitList.add(foodOrder.size());
					}
					if (i == 10) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "NOVEMBER");
						visitList.add(foodOrder.size());
					}
					if (i == 11) {
						foodOrder = orderRepository.findByUseridAndMonth(user.getUserid(), "DECEMBER");
						visitList.add(foodOrder.size());
					}
				}
				UserReport userRep = new UserReport();
				userRep.setUsername(user.getUsername());
				// userRep.setVisitList(visitList);

				userReport.add(userRep);

			}

			response.setData(userReport);
			response.setMessage("User Report");
			response.setStatus(AppConstants.STATUS_SUCCESS);

		} catch (BusinessException e) {
			logger.error("Error Message:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return response;
	}

	@Override
	public StatusResponse getCustomerReport(String month) {
		StatusResponse response = new StatusResponse();
		logger.info("inside getCustomerReport() ------ AdminServiceImpl class");

		try {

			List<User> userAll = userRepository.findByRole(AppConstants.ROLE_USER);
			List<UserReport> userReport = new ArrayList<UserReport>();
			UserReportResponse resp = new UserReportResponse();
			resp.setTotalUser(userAll.size());
			for (int j = 0; j < userAll.size(); j++) {
				List<Visit> visit = new ArrayList<>();
				// List<Integer> visitList = new ArrayList<Integer>();

				visit = visitRepository.findByUseridAndMonth(userAll.get(j).getUserid(), month);
				
				
				// visitList.add(visit.size());
				UserReport userRep = new UserReport();
				userRep.setUsername(userAll.get(j).getUsername());
				userRep.setVisitList(visit.size());
				
				userReport.add(userRep);
				
			}
			
			resp.setUserReport(userReport);
			
			response.setData(resp);
			response.setMessage("User Report");
			response.setStatus(AppConstants.STATUS_SUCCESS);

		} catch (BusinessException e) {
			logger.error("Error Message:" + e.getMessage());
			throw new BusinessException(e.getMessage());
		}

		return response;
	}

}
