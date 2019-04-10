package com.personal.OnSpaDi2.locationInformation;

public class LocationInformationResponse {
	private String message = "";
	private Integer id;
	
	public LocationInformationResponse(Integer id, String message ) {
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
