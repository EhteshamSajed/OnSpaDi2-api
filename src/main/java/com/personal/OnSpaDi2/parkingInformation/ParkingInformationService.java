package com.personal.OnSpaDi2.parkingInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.OnSpaDi2.locationInformation.LocationInformation;

//import com.personal.OnSpaDi2.locationInformation.LocationInformation;

@Service
public class ParkingInformationService {
	
	@Autowired
	private ParkingInformationRepository parkingInformationRepository;
	
	public List<ParkingInformation> getAllParkingInformation() {
		List<ParkingInformation> parkingInformation = new ArrayList<>();
		parkingInformationRepository.findAll().forEach(parkingInformation::add);
		return parkingInformation;
	}
	
	public List<ParkingInformation> getAllParkingInformation(int locationId) {
		List<ParkingInformation> parkingInformation = new ArrayList<>();
		//parkingInformationRepository.findAll().forEach(parkingInformation::add);
		parkingInformationRepository.findByLocationInformation_LocationId(locationId).forEach(parkingInformation::add);
		return parkingInformation;
	}
	
	public ParkingInformation getParkingInformationById(int parkingId) {
		return parkingInformationRepository.findById(parkingId).get();
	}
	
	public ParkingInformationResponse addParkingInformation(ParkingInformation parkingInformation) {
		parkingInformation = parkingInformationRepository.save(parkingInformation);
		return new ParkingInformationResponse(parkingInformation.getParkingId(), "New entry successfully created");
	}
	
	public ParkingInformationResponse updateParkingInformation(ParkingInformation ParkingInformation) {
		ParkingInformation = parkingInformationRepository.save(ParkingInformation);
		return new ParkingInformationResponse(ParkingInformation.getParkingId(), "Updated successfully");
	}
	
	public ParkingInformationResponse deleteParkingInformation(int id) {
		parkingInformationRepository.deleteById(id);
		return new ParkingInformationResponse(null, "Deleted successfully");
	}
	
	public int countParkingInformationByLocationId(int locationId) {		
		return parkingInformationRepository.countByLocationInformation_LocationId(locationId);
	}
	
	public Map<String, Object> convertParkingInformationToMap(ParkingInformation parkingInformation, String fields){
		
		Map<String, Object> informationMap = new HashMap<String, Object>();

		if (fields != null) {
			String[] fieldsArray = fields.split(",");		
			

			for (int i = 0; i < fieldsArray.length; i++) {
				switch (fieldsArray[i]) {
				case "parkingId":
					informationMap.put(fieldsArray[i], parkingInformation.getParkingId());
					break;
				case "sensorId":
					informationMap.put(fieldsArray[i], parkingInformation.getSensorId());
					break;
				case "currentParkingStates":
					informationMap.put(fieldsArray[i], parkingInformation.getCurrentParkingStates());					
					break;
				case "parkingHistory":
					informationMap.put(fieldsArray[i], parkingInformation.getParkingHistory());
					break;
				case "createdOn":
					informationMap.put(fieldsArray[i], parkingInformation.getCreatedOn());
					break;

				default:

				}
			}
		}else {
			informationMap.put("parkingId", parkingInformation.getParkingId());
			informationMap.put("sensorId", parkingInformation.getSensorId());
			informationMap.put("currentParkingStates", parkingInformation.getCurrentParkingStates());
			informationMap.put("parkingHistory", parkingInformation.getParkingHistory());
			informationMap.put("createdOn", parkingInformation.getCreatedOn());
		}		
		
		return informationMap;
	}
}
