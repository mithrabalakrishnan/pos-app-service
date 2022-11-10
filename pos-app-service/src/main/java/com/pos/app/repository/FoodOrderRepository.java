package com.pos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.app.model.FoodOrder;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{
	

	
	
}
