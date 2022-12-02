package com.pos.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pos.app.dto.FoodUpdateOrderDTO;
import com.pos.app.model.FoodOrder;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

	public List<FoodOrder> findByUserid(Integer userId);
	
	public List<FoodOrder> findByMonth(String month);
	
	public List<FoodOrder>  findByMonthAndFoodid(String month, int foodId);
	
	public FoodOrder findByFoodidAndUserid(Integer foodId, Integer userrId);
	
//	@Query("select select fo.id, fo.user_id, fo.food_id, fo.quanty, fo.table_id, fo.total_price, fo.date, fo.time, fo.day, fo.month, fo.year, fd.name, ur.username from food_order as fo \"\r\n" + 
//			"			+ \"join food as fd on fo.food_d = fd.food_id\"\r\n" + 
//			"			+ \"join user as ur on fo.user_id = ur.id")
//	public List<FoodUpdateOrderDTO> findAllFoodOrderList();
	
}
