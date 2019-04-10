package com.personal.OnSpaDi2.parkingInformation;

public class ParkingInformationResponse {
	private String message = "";
	private Integer id;
	
	public ParkingInformationResponse(Integer id, String message ) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}
