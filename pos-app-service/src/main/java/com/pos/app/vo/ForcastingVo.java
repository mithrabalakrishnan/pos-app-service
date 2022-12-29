package com.pos.app.vo;

import java.io.Serializable;
import java.util.List;

public class ForcastingVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ForcastingVo() {

	}

	public ForcastingVo(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

}
