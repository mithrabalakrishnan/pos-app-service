package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

public class FoodSaleReportDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String type;
	
	private List<FoodDetailsDto> food_details;
	
	private List<Integer> chart_data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<FoodDetailsDto> getFood_details() {
		return food_details;
	}

	public void setFood_details(List<FoodDetailsDto> food_details) {
		this.food_details = food_details;
	}

	public List<Integer> getChart_data() {
		return chart_data;
	}

	public void setChart_data(List<Integer> chart_data) {
		this.chart_data = chart_data;
	}
	
	
	public FoodSaleReportDto() {
		// TODO Auto-generated constructor stub
	}

	public FoodSaleReportDto(String type, List<FoodDetailsDto> food_details, List<Integer> chart_data) {
		super();
		this.type = type;
		this.food_details = food_details;
		this.chart_data = chart_data;
	}
	
	
	
	

}
