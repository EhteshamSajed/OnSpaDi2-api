package com.personal.OnSpaDi2.trend;

import java.util.Calendar;

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
import com.personal.OnSpaDi2.locationInformation.LocationInformation;

@Entity
public class Trend {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "locationId")
	@JsonIgnore	
	private LocationInformation locationInformation;
	@CreationTimestamp
	private Calendar dateTime;
	private int free;
	private int occupied;
	private int total;
	
	public Trend() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Calendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public int getOccupied() {
		return occupied;
	}
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}	
}