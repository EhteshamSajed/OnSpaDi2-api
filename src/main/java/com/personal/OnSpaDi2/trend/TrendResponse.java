package com.personal.OnSpaDi2.trend;

public class TrendResponse {
	private String message = "";
	private Long id;	
	
	public TrendResponse(String message, Long id) {
		super();
		this.message = message;
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
