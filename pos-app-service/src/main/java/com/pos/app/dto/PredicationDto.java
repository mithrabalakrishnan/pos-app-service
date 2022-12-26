package com.pos.app.dto;

import java.io.Serializable;
import java.util.Map;

public class PredicationDto implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> prediction;
	
	private Map<String, String> revenue;

	public Map<String, String> getPrediction() {
		return prediction;
	}

	public void setPrediction(Map<String, String> prediction) {
		this.prediction = prediction;
	}

	public Map<String, String> getRevenue() {
		return revenue;
	}

	public void setRevenue(Map<String, String> revenue) {
		this.revenue = revenue;
	}
	
	
	public PredicationDto() {
		// TODO Auto-generated constructor stub
	}

	public PredicationDto(Map<String, String> prediction, Map<String, String> revenue) {
		super();
		this.prediction = prediction;
		this.revenue = revenue;
	}
	
	
	

}
