package com.personal.OnSpaDi2.currentParkingState;

public class CurrentParkingStateResponse {
	private String message = "";
	private Long id;
	
	public CurrentParkingStateResponse(Long id, String message ) {
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
