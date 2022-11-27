package com.pos.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.app.model.FoodOrder;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

	public List<FoodOrder> findByUserId(Integer userId);
	
	public List<FoodOrder> findByMonth(String month);
	
	public List<FoodOrder>  findByMonthAndFoodId(String month, int foodId);
	
	public FoodOrder findByFoodIdAndUserId(Integer foodId, Integer userrId);
	
}
