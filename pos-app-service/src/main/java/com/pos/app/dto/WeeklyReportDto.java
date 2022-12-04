package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

public class WeeklyReportDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer foodId;
	
	private List<String> dateList;

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public List<String> getDateList() {
		return dateList;
	}

	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}
	
	

}
