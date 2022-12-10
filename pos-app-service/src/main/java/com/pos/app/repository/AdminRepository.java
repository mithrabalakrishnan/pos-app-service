package com.pos.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pos.app.model.Food;

@Repository
public interface AdminRepository extends JpaRepository<Food, Integer>{
	
	// public String findByfoodName(String name);
	
	public List<Food> findByStatus(String status);
	
	
	public Food findByFoodid(Integer foodId);
	
	//public Food findByFoodId(Integer id, Integer userId);
	
	//public  Food findByFoodIdAndUserId(Integer fid, Integer uid);
//	@Query("select f.category from food f")
//	public List<String> findByCategory();
	
	
	
	public List<Food> findByCategory(String category);
	

	
	

}
