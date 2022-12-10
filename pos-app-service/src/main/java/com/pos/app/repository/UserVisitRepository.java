package com.pos.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.app.model.Visit;

@Repository
public interface UserVisitRepository extends JpaRepository<Visit, Integer>{

	public List<Visit> findByUseridAndMonth(Integer userId, String month);
	
}
