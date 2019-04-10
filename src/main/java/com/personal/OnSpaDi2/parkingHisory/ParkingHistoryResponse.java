package com.personal.OnSpaDi2.parkingHisory;

public class ParkingHistoryResponse {
	private String message = "";
	private Long id;
	
	public ParkingHistoryResponse(Long id, String message ) {
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
