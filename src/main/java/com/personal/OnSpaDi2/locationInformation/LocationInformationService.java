package com.personal.OnSpaDi2.locationInformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationInformationService {
	
	@Autowired
	private LocationInformationRepository locationInformationRepository;
	
	public List<LocationInformation> getAllLocationInformation() {
		List<LocationInformation> locationInformation = new ArrayList<>();
		locationInformationRepository.findAll().forEach(locationInformation::add);
		return locationInformation;
	}
	
	public LocationInformation getLocationInformationById(int id) {
		return locationInformationRepository.findById(id).get();
	}
	
	public LocationInformationResponse addLocationInformation(LocationInformation locationInformation) {
		locationInformation = locationInformationRepository.save(locationInformation);
		return new LocationInformationResponse(locationInformation.getLocationId(), "New entry successfully created");
	}
	
	public LocationInformationResponse updateLocationInformation(LocationInformation locationInformation) {
		locationInformation = locationInformationRepository.save(locationInformation);
		return new LocationInformationResponse(locationInformation.getLocationId(), "Updated successfully");
	}
	
	public LocationInformationResponse updateTotalParkingsByLocationId(int id, int totalParkings) {
		LocationInformation locationInformation = getLocationInformationById(id);
		locationInformation.setTotalParkings(totalParkings);
		return updateLocationInformation(locationInformation);
	}
	
	public LocationInformationResponse deleteLocationInformation(int id) {
		locationInformationRepository.deleteById(id);
		return new LocationInformationResponse(null, "Deleted successfully");
	}
}
