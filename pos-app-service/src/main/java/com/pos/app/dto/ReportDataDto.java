package com.pos.app.dto;

import java.io.Serializable;
import java.util.List;

public class ReportDataDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String type;
	
	
	private Integer total_sale;;
	
	private Integer total_customers;
	
	private List<Integer> chart_data;
	
	public ReportDataDto() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTotal_sale() {
		return total_sale;
	}

	public void setTotal_sale(Integer total_sale) {
		this.total_sale = total_sale;
	}

	public Integer getTotal_customers() {
		return total_customers;
	}

	public void setTotal_customers(Integer total_customers) {
		this.total_customers = total_customers;
	}

	public List<Integer> getChart_data() {
		return chart_data;
	}

	public void setChart_data(List<Integer> chart_data) {
		this.chart_data = chart_data;
	}

	public ReportDataDto(String type, Integer total_sale, Integer total_customers, List<Integer> chart_data) {
		super();
		this.type = type;
		this.total_sale = total_sale;
		this.total_customers = total_customers;
		this.chart_data = chart_data;
	}
	
	

}
