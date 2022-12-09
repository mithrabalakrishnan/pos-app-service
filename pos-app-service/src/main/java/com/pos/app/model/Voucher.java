package com.pos.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voucher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer voucherId;
	
	@Column
	private String voucherCode;

	@Column
	private String voucherDiscount;

	@Column
	private String voucherTitle;

	@Column
	private String date;
	
	
	public Voucher() {
		
	}


	public Integer getVoucherId() {
		return voucherId;
	}


	public void setVoucherId(Integer voucherId) {
		this.voucherId = voucherId;
	}


	public String getVoucherCode() {
		return voucherCode;
	}


	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}


	public String getVoucherDiscount() {
		return voucherDiscount;
	}


	public void setVoucherDiscount(String voucherDiscount) {
		this.voucherDiscount = voucherDiscount;
	}


	public String getVoucherTitle() {
		return voucherTitle;
	}


	public void setVoucherTitle(String voucherTitle) {
		this.voucherTitle = voucherTitle;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Voucher(Integer voucherId, String voucherCode, String voucherDiscount, String voucherTitle, String date) {
		super();
		this.voucherId = voucherId;
		this.voucherCode = voucherCode;
		this.voucherDiscount = voucherDiscount;
		this.voucherTitle = voucherTitle;
		this.date = date;
	}
	
	
}
