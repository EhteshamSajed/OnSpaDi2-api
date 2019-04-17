package com.personal.OnSpaDi2.currentParkingState;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.OnSpaDi2.locationInformation.LocationInformation;
import com.personal.OnSpaDi2.parkingHisory.ParkingHistory;
import com.personal.OnSpaDi2.parkingHisory.ParkingHistoryService;
import com.personal.OnSpaDi2.parkingInformation.ParkingInformation;
import com.personal.OnSpaDi2.parkingInformation.ParkingInformationService;

@RestController
public class CurrentParkingStateController {
	
	@Autowired
	private CurrentParkingStateService currentParkingStateService;
	
	@Autowired
	private ParkingInformationService parkingInformationService;
	
	@Autowired
	private ParkingHistoryService parkingHistoryService;
	
	@RequestMapping("/currentParkingState")
	public List<CurrentParkingState> getAllCurrentParkingState(){
		return currentParkingStateService.getAllCurrentParkingStates();
	}
	
	@RequestMapping("/parkingInformation/{id}/currentParkingState")
	public CurrentParkingState getAllCurrentParkingState(@PathVariable int id){
		return currentParkingStateService.getcurrentParkingStateByParkingId(id);
	}
	
	@RequestMapping("/currentParkingState/{id}")
	public CurrentParkingState getCurrentParkingStateById(@PathVariable long id) {
		return currentParkingStateService.getcurrentParkingStateById(id);
	}	
	
	@RequestMapping("/locationInformation/{locationId}/currentParkingState")
	public List<CurrentParkingState> getAllCurrentParkingStatesByLocation(@PathVariable int locationId){
		return currentParkingStateService.getAllCurrentParkingStatesForLocation(locationId);
	}
	
	@RequestMapping("/countParkings")
	public List<Map<String, Object>> countParkings(@RequestParam(required = false) String fields){		
		return currentParkingStateService.countParkingByLocation(fields);
	}
	
	@RequestMapping("/locationInformation/{locationId}/countParkings")
	public Map<String, Object> countParkingsByLocation(@PathVariable int locationId , @RequestParam(required = false) String fields){		
		return currentParkingStateService.countParkingByLocation(locationId, fields);
	}	
		
	@RequestMapping(method = RequestMethod.POST, value = "/parkingInformation/{parkingId}/currentParkingState")
	public CurrentParkingStateResponse addCurrentParkingState(@RequestBody CurrentParkingState _currentParkingState, @PathVariable int parkingId) {
		
		CurrentParkingState currentParkingState =  currentParkingStateService.getcurrentParkingStateByParkingId(parkingId);
		if(currentParkingState != null)					//		if exists
		{			
			currentParkingState.setSensorState(_currentParkingState.getSensorState());
			currentParkingState.setParkingState(_currentParkingState.getParkingState());
		}else {											//		new entry			
			currentParkingState = _currentParkingState;
			currentParkingState.setParkingInformation(new ParkingInformation(parkingId, 0, 0));
			int locationId = parkingInformationService.getParkingInformationById(parkingId).getLocationInformation().getLocationId();
			currentParkingState.setLocationInformation(new LocationInformation(locationId));
		}
		
		ParkingHistory parkingHistory = new ParkingHistory(parkingId, currentParkingState.getParkingState(), currentParkingState.getSensorState());
		
		parkingHistoryService.addParkingHistory(parkingHistory);
		
		return currentParkingStateService.addCurrentParkingState(currentParkingState);
	}	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/currentParkingState/{id}")
	public CurrentParkingStateResponse deleteCurrentParkingState(@PathVariable long id) {
		return currentParkingStateService.deleteCurrentParkingState(id);
	}
}
