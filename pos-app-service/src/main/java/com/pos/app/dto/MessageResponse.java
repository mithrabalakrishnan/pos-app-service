package com.pos.app.dto;

import java.io.Serializable;

public class MessageResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public MessageResponse() {
		// TODO Auto-generated constructor stub
	}

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
