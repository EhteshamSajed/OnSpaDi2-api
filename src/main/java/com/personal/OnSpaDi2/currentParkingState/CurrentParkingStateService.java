package com.personal.OnSpaDi2.currentParkingState;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentParkingStateService {
	
	@Autowired
	private CurrentParkingStateRepository currentParkingStateRepository;
	
	public List<CurrentParkingState> getAllCurrentParkingStates() {
		List<CurrentParkingState> currentParkingState = new ArrayList<>();
		currentParkingStateRepository.findAll().forEach(currentParkingState::add);
		return currentParkingState;
	}
	
	public List<CurrentParkingState> getAllCurrentParkingStates(int id) {			//		wrong, make it for locationId
		List<CurrentParkingState> currentParkingState = new ArrayList<>();
		//currentParkingStateRepository.findByParkingInformation_ParkingId(id).forEach(currentParkingState::add);
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
}
