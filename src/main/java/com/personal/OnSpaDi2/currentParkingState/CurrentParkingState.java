package com.personal.OnSpaDi2.currentParkingState;


import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.personal.OnSpaDi2.locationInformation.LocationInformation;
import com.personal.OnSpaDi2.parkingInformation.ParkingInformation;

@Entity
public class CurrentParkingState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "parkingId")
	@JsonIgnore
	private ParkingInformation parkingInformation;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "locationId")
	@JsonIgnore	
	private LocationInformation locationInformation;
	private String parkingState;
	private String sensorState;
	@UpdateTimestamp
	private Calendar lastUpdatedOn;
	
	public CurrentParkingState() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CurrentParkingState(String parkingId, String parkingState, String sensorState, int parkingInformationId) {
		super();
		//this.parkingId = parkingId;
		this.parkingState = parkingState;
		this.sensorState = sensorState;
		this.parkingInformation = new ParkingInformation(parkingInformationId, 0, 0);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Calendar getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Calendar lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public ParkingInformation getParkingInformation() {
		return parkingInformation;
	}
	public void setParkingInformation(ParkingInformation parkingInformation) {
		this.parkingInformation = parkingInformation;
	}
	public int getParkingId() {
		return getParkingInformation().getParkingId();
	}
	public LocationInformation getLocationInformation() {
		return locationInformation;
	}
	public void setLocationInformation(LocationInformation locationInformation) {
		this.locationInformation = locationInformation;
	}
	public int getLocationId() {
		return locationInformation.getLocationId();
	}
}
