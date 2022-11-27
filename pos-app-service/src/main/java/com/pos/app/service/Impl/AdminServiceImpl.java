package com.pos.app.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pos.app.dto.FoodDTO;
import com.pos.app.dto.FoodDetailsDto;
import com.pos.app.dto.FoodSaleReportDto;
import com.pos.app.dto.OrderDetailsDto;
import com.pos.app.dto.ReportDataDto;
import com.pos.app.exception.BusinessException;
import com.pos.app.model.Food;
import com.pos.app.model.FoodOrder;
import com.pos.app.model.TableDetail;
import com.pos.app.repository.AdminRepository;
import com.pos.app.repository.FoodOrderRepository;
import com.pos.app.repository.UserBookingRepository;
import com.pos.app.service.AdminService;

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

	@Override
	public Food addMenu(FoodDTO food) throws BusinessException {

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
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Jan  in AdminServiceImpl");

				if (i == 2) {

					List<FoodOrder> oder = orderRepository.findByMonth("FEBRUARY");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Feb  in AdminServiceImpl");

				if (i == 3) {

					List<FoodOrder> oder = orderRepository.findByMonth("MARCH");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Mar  in AdminServiceImpl");

				if (i == 4) {

					List<FoodOrder> oder = orderRepository.findByMonth("APRIL");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after April  in AdminServiceImpl");

				if (i == 5) {

					List<FoodOrder> oder = orderRepository.findByMonth("MAY");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after May  in AdminServiceImpl");

				if (i == 6) {

					List<FoodOrder> oder = orderRepository.findByMonth("JUNE");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Jun  in AdminServiceImpl");

				if (i == 7) {

					List<FoodOrder> oder = orderRepository.findByMonth("JULY");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after July  in AdminServiceImpl");

				if (i == 8) {

					List<FoodOrder> oder = orderRepository.findByMonth("AUGUST");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Aug  in AdminServiceImpl");

				if (i == 9) {

					List<FoodOrder> oder = orderRepository.findByMonth("SEPTEMBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Sep  in AdminServiceImpl");

				if (i == 10) {

					List<FoodOrder> oder = orderRepository.findByMonth("OCTOBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Oct  in AdminServiceImpl");

				if (i == 11) {

					List<FoodOrder> oder = orderRepository.findByMonth("NOVEMBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
					}

					monthAmount.add(totalPrice);

				}

				logger.info("inside getMonthlyReport() after Nov  in AdminServiceImpl");

				if (i == 12) {

					List<FoodOrder> oder = orderRepository.findByMonth("DECEMBER");

					Integer totalPrice = 0;

					for (int j = 0; j < oder.size(); j++) {
						totalPrice += oder.get(j).getTotalPrice();
						customerList.add(oder.get(i).getUserId());
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
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("JANUARY", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}
				logger.info("inside getMonthlyFoodReport() after jan  in AdminServiceImpl");

				if (i == 2) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("FEBRUARY",
								food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after Feb  in AdminServiceImpl");

				if (i == 3) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("MARCH", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after March  in AdminServiceImpl");

				if (i == 4) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("APRIL", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after Feb  in AdminServiceImpl");

				if (i == 5) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("MAY", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after Feb  in AdminServiceImpl");

				if (i == 6) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("JUNE", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after JUNE  in AdminServiceImpl");

				if (i == 7) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("JULY", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after JULY  in AdminServiceImpl");

				if (i == 8) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("AUGUST", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);
					}
				}

				logger.info("inside getMonthlyFoodReport() after AUGUST  in AdminServiceImpl");

				if (i == 9) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("SEPTEMBER",
								food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);
					}
				}

				logger.info("inside getMonthlyFoodReport() after SEPTEMBER  in AdminServiceImpl");

				if (i == 10) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("OCTOBER", food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);
					}
				}

				logger.info("inside getMonthlyFoodReport() after OCTOBER  in AdminServiceImpl");

				if (i == 11) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("NOVEMBER",
								food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
						foodDetails.add(foodDetail);
						priceList.add(foodPrice);

					}
				}

				logger.info("inside getMonthlyFoodReport() after NOVEMBER  in AdminServiceImpl");

				if (i == 12) {
					List<Food> food = adminRepository.findAll();
					for (int j = 0; j < food.size(); j++) {
						Integer foodPrice = 0;
						List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("DECEMBER",
								food.get(j).getFoodId());

						for (int k = 0; k < oder.size(); k++) {
							foodPrice += oder.get(k).getTotalPrice();
						}

						FoodDetailsDto foodDetail = new FoodDetailsDto(food.get(j).getName(), foodPrice);
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
					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("JANUARY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 2) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("FEBRUARY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 3) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("MARCH", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 4) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("APRIL", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 5) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("MAY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 6) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("JUNE", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 7) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("JULY", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}
				if (i == 8) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("AUGUST", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 9) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("SEPTEMBER", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 10) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("OCTOBER", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 11) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("NOVEMBER", foodId);

					for (int k = 0; k < oder.size(); k++) {
						foodPrice += oder.get(k).getTotalPrice();
					}
					chart_data.add(foodPrice);
				}

				if (i == 12) {
					Integer foodPrice = 0;

					List<FoodOrder> oder = orderRepository.findByMonthAndFoodId("DECEMBER", foodId);

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

}
