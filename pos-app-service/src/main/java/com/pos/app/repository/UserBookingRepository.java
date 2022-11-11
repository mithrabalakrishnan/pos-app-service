package com.pos.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.app.model.TableDetail;

@Repository
public interface UserBookingRepository extends JpaRepository<TableDetail, Integer> {

	public List<TableDetail> findByUserId(Integer userId);
	
	public TableDetail findByTimeAndDate(String time, String date);

}
