package com.personal.OnSpaDi2.locationInformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationInformationController {
	
	@Autowired
	private LocationInformationService locationInformationService;
	
	@RequestMapping("/locationInformation")
	public List<LocationInformation> getAllLocationInformation(){
		return locationInformationService.getAllLocationInformation();
	}
	
	@RequestMapping("/locationInformation/{id}")
	public LocationInformation getParkingLocationById(@PathVariable int id) {
		return locationInformationService.getLocationInformationById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/locationInformation")
	public LocationInformationResponse addLocationInformation(@RequestBody LocationInformation locationInformation) {
		return locationInformationService.addLocationInformation(locationInformation);		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/locationInformation")
	public LocationInformationResponse updatelocationInformation(@RequestBody LocationInformation locationInformation) {
		return locationInformationService.updateLocationInformation(locationInformation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/locationInformation/{id}")
	public LocationInformationResponse deleteLocationInformation(@PathVariable int id) {
		return locationInformationService.deleteLocationInformation(id);
	}
}
