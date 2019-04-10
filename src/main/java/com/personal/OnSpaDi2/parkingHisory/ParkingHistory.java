package com.personal.OnSpaDi2.parkingHisory;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.OnSpaDi2.parkingInformation.ParkingInformation;

@Entity
public class ParkingHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "parkingId")
	@JsonIgnore
	private ParkingInformation parkingInformation;	
	private String parkingState;
	private String sensorState;
	@CreationTimestamp
	private Calendar dateTime;
		


	public ParkingHistory() {
		//super();
	}
	
	

	public ParkingHistory(String parkingId, String parkingState, String sensorState, int parkingInformationId) {
		super();
		
		//this.parkingIdOld = parkingId;
		this.parkingState = parkingState;
		this.sensorState = sensorState;
		this.parkingInformation = new ParkingInformation(parkingInformationId, 0, 0);
		
		/*Calendar cal = Calendar.getInstance();		
		this.date = cal.get(Calendar.DATE);		
		this.minute = cal.get(Calendar.MINUTE);*/
	}

	public ParkingHistory(String parkingId, String parkingState, String sensorState, Calendar dateTime, int parkingInformationId) {
		super();
		
		//this.parkingIdOld = parkingId;
		this.parkingState = parkingState;
		this.sensorState = sensorState;
		this.dateTime = dateTime;
		this.parkingInformation = new ParkingInformation(parkingInformationId, 0, 0);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public String getParkingId() {
		return parkingIdOld;
	}
	public void setParkingId(String parkingId) {
		this.parkingIdOld = parkingId;
	}*/
	public String getParkingState() {
		return parkingState;
	}
	public void setParkingState(String parkingState) {
		this.parkingState = parkingState;
	}
	public String getSensorState() {
		return sensorState;
	}
	public void setSensorState(String sensorState) {
		this.sensorState = sensorState;
	}	
	public Calendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	public ParkingInformation getParkingInformation() {
		return parkingInformation;
	}
	public void setParkingInformation(ParkingInformation parkingInformation) {
		this.parkingInformation = parkingInformation;
	}
}
