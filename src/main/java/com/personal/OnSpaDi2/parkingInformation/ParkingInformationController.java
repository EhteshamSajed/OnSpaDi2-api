package com.personal.OnSpaDi2.parkingInformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.OnSpaDi2.locationInformation.LocationInformation;
import com.personal.OnSpaDi2.locationInformation.LocationInformationService;

@RestController
public class ParkingInformationController {
	
	@Autowired
	private ParkingInformationService parkingInformationService;
	
	@Autowired
	private LocationInformationService locationInformationService;
	
	@RequestMapping("/parkingInformation")
	public List<ParkingInformation> getAllParkingInformation(){
		return parkingInformationService.getAllParkingInformation();
	}
	
	@RequestMapping("/locationInformation/{locationId}/parkingInformation")
	public List<ParkingInformation> getAllParkingInformation(@PathVariable int locationId){
		return parkingInformationService.getAllParkingInformation(locationId);
	}
	
	@RequestMapping("/parkingInformation/{id}")
	public ParkingInformation getParkingInformationById(@PathVariable int id) {
		return parkingInformationService.getParkingInformationById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/parkingInformation")
	public ParkingInformationResponse addParkingInformation(@RequestBody ParkingInformation parkingInformation) {
		return parkingInformationService.addParkingInformation(parkingInformation);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/locationInformation/{locationId}/parkingInformation")
	public ParkingInformationResponse addParkingInformation(@RequestBody ParkingInformation parkingInformation, @PathVariable int locationId) {
		parkingInformation.setLocationInformation(new LocationInformation(locationId));
		ParkingInformationResponse response = parkingInformationService.addParkingInformation(parkingInformation); 
		
		int totalParkings = parkingInformationService.countParkingInformationByLocationId(locationId);
		locationInformationService.updateTotalParkingsByLocationId(locationId, totalParkings);
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/parkingInformation")
	public ParkingInformationResponse updateParkingInformation(@RequestBody ParkingInformation parkingInformation) {
		return parkingInformationService.updateParkingInformation(parkingInformation);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/locationInformation/{locationId}/parkingInformation")
	public ParkingInformationResponse updateParkingInformation(@RequestBody ParkingInformation parkingInformation, @PathVariable int locationId) {
		parkingInformation.setLocationInformation(new LocationInformation(locationId));
		
		return parkingInformationService.updateParkingInformation(parkingInformation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkingInformation/{id}")
	public ParkingInformationResponse deleteParkingInformation(@PathVariable int id) {		
		int locationId = parkingInformationService.getParkingInformationById(id).getLocationInformation().getLocationId();
		ParkingInformationResponse response = parkingInformationService.deleteParkingInformation(id);
		int totalParkings = parkingInformationService.countParkingInformationByLocationId(locationId);
		locationInformationService.updateTotalParkingsByLocationId(locationId, totalParkings);
		
		return response;
	}
	
	@RequestMapping("/countParking/{locationId}")
	public int countParkingInformationByLocationId(@PathVariable int locationId) {
		return parkingInformationService.countParkingInformationByLocationId(locationId);
	}
}
