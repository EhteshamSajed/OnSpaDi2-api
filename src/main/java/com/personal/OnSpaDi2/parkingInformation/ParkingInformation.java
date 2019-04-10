package com.personal.OnSpaDi2.parkingInformation;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.OnSpaDi2.currentParkingState.CurrentParkingState;
import com.personal.OnSpaDi2.locationInformation.LocationInformation;
import com.personal.OnSpaDi2.parkingHisory.ParkingHistory;

@Entity
public class ParkingInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parkingId", updatable = false, nullable = false)	
	private int parkingId;
	//private int parkingId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "locationId")
	@JsonIgnore
	private LocationInformation locationInformation;
	//private int locationId;
	private int sensorId;
	@CreationTimestamp
	private Calendar createdOn;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "parkingInformation")
	private List<ParkingHistory> parkingHistory;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "parkingInformation")
	private List<CurrentParkingState> currentParkingStates;
	

	public ParkingInformation() {
		super();
	}	
	
	public ParkingInformation(int parkingId, int locationId, int sensorId) {
		super();
		this.parkingId = parkingId;
		//this.locationId = locationId;
		this.locationInformation = new LocationInformation("", "", "");
		this.sensorId = sensorId;
	}



	/*public int getpId() {
		return parkingId;
	}
	public void setpId(int pId) {
		this.parkingId = pId;
	}
	/*public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}*/
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	public Calendar getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}	
	public List<ParkingHistory> getParkingHistory() {
		return parkingHistory;
	}
	public void setParkingHistory(List<ParkingHistory> parkingHistory) {
		this.parkingHistory = parkingHistory;
	}
	public LocationInformation getLocationInformation() {
		return locationInformation;
	}
	public void setLocationInformation(LocationInformation locationInformation) {
		this.locationInformation = locationInformation;
	}
	public List<CurrentParkingState> getCurrentParkingStates() {
		return currentParkingStates;
	}
	public void setCurrentParkingStates(List<CurrentParkingState> currentParkingStates) {
		this.currentParkingStates = currentParkingStates;
	}
	
}
