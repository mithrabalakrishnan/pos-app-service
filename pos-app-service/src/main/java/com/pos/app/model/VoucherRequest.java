package com.pos.app.model;

import java.io.Serializable;

public class VoucherRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String voucherCode;

	private String voucherDiscount;

	private String voucherTitle;

	private String date;

	public VoucherRequest() {

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

	public VoucherRequest(String voucherCode, String voucherDiscount, String voucherTitle, String date) {
		super();
		this.voucherCode = voucherCode;
		this.voucherDiscount = voucherDiscount;
		this.voucherTitle = voucherTitle;
		this.date = date;
	}

}
