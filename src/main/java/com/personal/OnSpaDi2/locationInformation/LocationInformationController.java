package com.personal.OnSpaDi2.locationInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationInformationController {
	
	@Autowired
	private LocationInformationService locationInformationService;
	
	@RequestMapping("/locationInformation")
	public List<LocationInformation> getAllLocationInformation(){
		return locationInformationService.getAllLocationInformation();
	}
	
	/*@RequestMapping("/locationInformation/{id}")						//			temporal disabled
	public LocationInformation getParkingLocationById(@PathVariable int id) {
		return locationInformationService.getLocationInformationById(id);
	}*/
	
	@RequestMapping("/locationInformation/{id}")
	public Map<String, Object> getParkingLocationById(@PathVariable int id, @RequestParam(required = false) String fields) {		
		LocationInformation locationInformation = locationInformationService.getLocationInformationById(id);
		return locationInformationService.convertLocationInformationToMap(locationInformation, fields);
		
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
