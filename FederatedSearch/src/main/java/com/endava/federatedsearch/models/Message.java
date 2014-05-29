package com.endava.federatedsearch.models;

public class Message {

	private String message;
	private String detail;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		return "Message [message=" + message + ", detail=" + detail + "]";
	}
	
	
}
