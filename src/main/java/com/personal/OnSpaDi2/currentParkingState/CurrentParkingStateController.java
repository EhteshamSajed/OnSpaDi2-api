package com.personal.OnSpaDi2.currentParkingState;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.OnSpaDi2.parkingInformation.ParkingInformation;

@RestController
public class CurrentParkingStateController {
	
	@Autowired
	private CurrentParkingStateService currentParkingStateService;
	
	@RequestMapping("/currentParkingState")
	public List<CurrentParkingState> getAllCurrentParkingState(){
		return currentParkingStateService.getAllCurrentParkingStates();
	}
	
	@RequestMapping("/parkingInformation/{id}/currentParkingState")
	public List<CurrentParkingState> getAllCurrentParkingState(@PathVariable int id){				//		wrong, make it for locationId
		return currentParkingStateService.getAllCurrentParkingStates(id);
	}	
	
	@RequestMapping("/currentParkingState/{id}")
	public CurrentParkingState getCurrentParkingStateById(@PathVariable long id) {
		return currentParkingStateService.getcurrentParkingStateById(id);
	}
	
	@RequestMapping("/currentParkingStateForParkingId/{id}")										//		remove it
	public CurrentParkingState getCurrentParkingStateByParkingId(@PathVariable int id) {
		return currentParkingStateService.getcurrentParkingStateByParkingId(id);
	}
	
	@RequestMapping("/locationInformation/{locationId}/currentParkingState")
	public List<CurrentParkingState> getAllCurrentParkingStatesByLocation(@PathVariable int locationId){				//		wrong, make it for locationId
		return currentParkingStateService.getAllCurrentParkingStates(locationId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/currentParkingState")
	public CurrentParkingStateResponse addCurrentParkingState(@RequestBody CurrentParkingState currentParkingState) {
		return currentParkingStateService.addCurrentParkingState(currentParkingState);		
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/parkingInformation/{parkingInformationId}/currentParkingState")
	public CurrentParkingStateResponse addCurrentParkingState(@RequestBody CurrentParkingState _currentParkingState, @PathVariable int parkingInformationId) {
		
		CurrentParkingState currentParkingState =  currentParkingStateService.getcurrentParkingStateByParkingId(parkingInformationId);
		if(currentParkingState != null)					//		if exists
		{			
			currentParkingState.setSensorState(_currentParkingState.getSensorState());
			currentParkingState.setParkingState(_currentParkingState.getParkingState());
		}else {											//		new entry			
			currentParkingState = _currentParkingState;
			currentParkingState.setParkingInformation(new ParkingInformation(parkingInformationId, 0, 0));
		}
		
		
		return currentParkingStateService.addCurrentParkingState(currentParkingState);
	}		
	
	@RequestMapping(method = RequestMethod.PUT, value = "/currentParkingState")
	public CurrentParkingStateResponse updateCurrentParkingState(@RequestBody CurrentParkingState currentParkingState) {
		return currentParkingStateService.updateCurrentParkingState(currentParkingState);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/parkingInformation/{parkingInformationId}/currentParkingState")
	public CurrentParkingStateResponse updateCurrentParkingState(@RequestBody CurrentParkingState currentParkingState, @PathVariable int parkingInformationId) {
		currentParkingState.setParkingInformation(new ParkingInformation(parkingInformationId, 0, 0));
		return currentParkingStateService.updateCurrentParkingState(currentParkingState);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/currentParkingState/{id}")
	public CurrentParkingStateResponse deleteCurrentParkingState(@PathVariable long id) {
		return currentParkingStateService.deleteCurrentParkingState(id);
	}
}
