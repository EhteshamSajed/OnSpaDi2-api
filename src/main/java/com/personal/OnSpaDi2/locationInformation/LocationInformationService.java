package com.personal.OnSpaDi2.locationInformation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.OnSpaDi2.parkingInformation.ParkingInformation;

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
	
	public Map<String, Object> convertLocationInformationToMap(LocationInformation locationInformation, String fields){
		
		Map<String, Object> informationMap = new HashMap<String, Object>();

		if (fields != null) {
			String[] fieldsArray = fields.split(",");

			for (int i = 0; i < fieldsArray.length; i++) {
				switch (fieldsArray[i]) {
				case "locationId":
					informationMap.put(fieldsArray[i], locationInformation.getLocationId());
					break;
				case "locationName":
					informationMap.put(fieldsArray[i], locationInformation.getLocationName());
					break;
				case "latitude":
					informationMap.put(fieldsArray[i], locationInformation.getLatitude());
					break;
				case "longitude":
					informationMap.put(fieldsArray[i], locationInformation.getLongitude());
					break;
				case "totalParkings":
					informationMap.put(fieldsArray[i], locationInformation.getTotalParkings());
					break;
				case "createdOn":
					informationMap.put(fieldsArray[i], locationInformation.getCreatedOn());
					break;
				case "parkingInformations":
					informationMap.put(fieldsArray[i], locationInformation.getParkingInformations());
					break;

				default:

				}
			}
		}else {
			informationMap.put("locationId", locationInformation.getLocationId());
			informationMap.put( "locationName", locationInformation.getLocationName());
			informationMap.put("latitude", locationInformation.getLatitude());
			informationMap.put("longitude", locationInformation.getLongitude());
			informationMap.put("totalParkings", locationInformation.getTotalParkings());
			informationMap.put("createdOn", locationInformation.getCreatedOn());
			informationMap.put("parkingInformations", locationInformation.getParkingInformations());
		}		
		
		return informationMap;
	}
}
