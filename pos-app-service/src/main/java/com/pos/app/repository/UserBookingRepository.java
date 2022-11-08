package com.pos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.app.model.TableDetail;

@Repository
public interface UserBookingRepository extends JpaRepository<TableDetail, Integer>{
	
	

}
