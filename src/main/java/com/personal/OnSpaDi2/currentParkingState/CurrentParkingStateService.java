package com.personal.OnSpaDi2.currentParkingState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.OnSpaDi2.locationInformation.LocationInformation;
import com.personal.OnSpaDi2.locationInformation.LocationInformationService;

@Service
public class CurrentParkingStateService {
	
	@Autowired
	private CurrentParkingStateRepository currentParkingStateRepository;
	
	@Autowired	
	LocationInformationService locationInformationService = new LocationInformationService();
	
	public List<CurrentParkingState> getAllCurrentParkingStates() {
		List<CurrentParkingState> currentParkingState = new ArrayList<>();
		currentParkingStateRepository.findAll().forEach(currentParkingState::add);
		return currentParkingState;
	}
	
	public List<CurrentParkingState> getAllCurrentParkingStatesForLocation(int locationId) {
		List<CurrentParkingState> currentParkingState = new ArrayList<>();
		currentParkingStateRepository.findByLocationInformation_LocationId(locationId).forEach(currentParkingState::add);
		return currentParkingState;
	}
	
	public CurrentParkingState getcurrentParkingStateById(long id) {
		return currentParkingStateRepository.findById(id).get();
	}
	
	public CurrentParkingState getcurrentParkingStateByParkingId(int id) {
		return currentParkingStateRepository.findByParkingInformation_ParkingId(id);
	}
	
	public CurrentParkingStateResponse addCurrentParkingState(CurrentParkingState currentParkingState) {
		currentParkingState = currentParkingStateRepository.save(currentParkingState);
		return new CurrentParkingStateResponse(currentParkingState.getId(), "New entry successfully created");
	}
	
	public CurrentParkingStateResponse updateCurrentParkingState(CurrentParkingState currentParkingState) {
		currentParkingState = currentParkingStateRepository.save(currentParkingState);
		return new CurrentParkingStateResponse(currentParkingState.getId(), "Updated successfully");
	}
	
	public CurrentParkingStateResponse deleteCurrentParkingState(long id) {
		currentParkingStateRepository.deleteById(id);
		return new CurrentParkingStateResponse(null, "Deleted successfully");
	}
	
	public List<Map<String, Object>> countParkingByLocation(String fields) {
		List<LocationInformation> locationInformations = locationInformationService.getAllLocationInformation();		
		int[] locationIds = new int[locationInformations.size()];		
		List<Map<String, Object>> countMaps = new ArrayList<Map<String, Object>>();				
		
		for(int i=0; i<locationIds.length; i++) {
			locationIds[i] = locationInformations.get(i).getLocationId();			
			countMaps.add(countParkingByLocation(locationIds[i], fields));
		}
		
		return countMaps;
	}
	
	public Map<String, Object> countParkingByLocation(int locationId , String fields) {		
		Map<String, Object> countMap = new HashMap<String, Object>();
		
		if (fields != null) {
			String[] fieldsArray = fields.split(",");			

			for (int i = 0; i < fieldsArray.length; i++) {
				switch (fieldsArray[i]) {
				case "total":
					countMap.put("total", currentParkingStateRepository.countByLocationInformation_LocationId(locationId));
					break;
				case "free":
					countMap.put("free", currentParkingStateRepository.countByParkingStateAndLocationInformation_LocationId("0", locationId));
					break;
				case "occupied":
					countMap.put("occupied", currentParkingStateRepository.countByParkingStateAndLocationInformation_LocationId("1", locationId));
					break;
				case "locationId":
					countMap.put("locationId", locationId);
					break;
				default:

				}
			}
		} else {
			countMap.put("total", currentParkingStateRepository.countByLocationInformation_LocationId(locationId));
			countMap.put("free", currentParkingStateRepository.countByParkingStateAndLocationInformation_LocationId("0", locationId));
			countMap.put("occupied", currentParkingStateRepository.countByParkingStateAndLocationInformation_LocationId("1", locationId));	
			countMap.put("locationId", locationId);
		}
		
		return countMap;
	}	
}
