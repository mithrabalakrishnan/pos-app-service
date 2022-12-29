package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

import com.pos.app.vo.ForcastingVo;

public class PredicationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ForcastingVo> prediction;

	private List<ForcastingVo> revenue;

	public PredicationDto() {
		// TODO Auto-generated constructor stub
	}

	public PredicationDto(List<ForcastingVo> prediction, List<ForcastingVo> revenue) {
		super();
		this.prediction = prediction;
		this.revenue = revenue;
	}

	public List<ForcastingVo> getPrediction() {
		return prediction;
	}

	public void setPrediction(List<ForcastingVo> prediction) {
		this.prediction = prediction;
	}

	public List<ForcastingVo> getRevenue() {
		return revenue;
	}

	public void setRevenue(List<ForcastingVo> revenue) {
		this.revenue = revenue;
	}
	
	

}
