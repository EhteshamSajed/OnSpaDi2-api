package com.personal.OnSpaDi2.locationInformation;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.personal.OnSpaDi2.currentParkingState.CurrentParkingState;
import com.personal.OnSpaDi2.parkingInformation.ParkingInformation;
import com.personal.OnSpaDi2.trend.Trend;

@Entity
public class LocationInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locationId", updatable = false, nullable = false)
	private int locationId;
	private String locationName;
	private String latitude;
	private String longitude;
	private int totalParkings;
	@CreationTimestamp
	private Calendar createdOn;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "locationInformation")
	private List<ParkingInformation> parkingInformations;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "locationInformation")
	private List<CurrentParkingState> currentParkingStates;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "locationInformation")
	private List<Trend> trend;
	
	
	public LocationInformation() {
		super();
	}
	public LocationInformation(int locationId) {
		super();
		this.locationId = locationId;
	}
	public LocationInformation(String locationName, String latitude, String longitude) {
		super();
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Calendar getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	public List<ParkingInformation> getParkingInformations() {
		return parkingInformations;
	}
	public void setParkingInformations(List<ParkingInformation> parkingInformations) {
		this.parkingInformations = parkingInformations;
	}
	public int getTotalParkings() {
		return totalParkings;
	}
	public void setTotalParkings(int totalParkings) {
		this.totalParkings = totalParkings;
	}
	public List<CurrentParkingState> getCurrentParkingStates() {
		return currentParkingStates;
	}
	public void setCurrentParkingStates(List<CurrentParkingState> currentParkingStates) {
		this.currentParkingStates = currentParkingStates;
	}
	public List<Trend> getTrend() {
		return trend;
	}
	public void setTrend(List<Trend> trend) {
		this.trend = trend;
	}
}
