package com.personal.OnSpaDi2.parkingHisory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingHistoryService {
	
	@Autowired
	private ParkingHistoryRepository parkingHistoryRepository;
	
	public List<ParkingHistory> getAllParkingHistory() {
		List<ParkingHistory> parkingHistory = new ArrayList<>();
		parkingHistoryRepository.findAll().forEach(parkingHistory::add);
		return parkingHistory;
	}
	
	public List<ParkingHistory> getAllParkingHistory(Integer id) {
		List<ParkingHistory> parkingHistory = new ArrayList<>();
		parkingHistoryRepository.findByParkingInformation_ParkingId(id).forEach(parkingHistory::add);
		return parkingHistory;
	}
	
	public ParkingHistory getParkingHistoryById(long id) {
		return parkingHistoryRepository.findById(id).get();
	}
	
	public ParkingHistoryResponse addParkingHistory(ParkingHistory parkingHistory) {
		parkingHistory = parkingHistoryRepository.save(parkingHistory);
		return new ParkingHistoryResponse(parkingHistory.getId(), "New entry successfully created");
	}
	
	public ParkingHistoryResponse updateParkingHistory(ParkingHistory parkingHistory) {
		parkingHistory = parkingHistoryRepository.save(parkingHistory);
		return new ParkingHistoryResponse(parkingHistory.getId(), "Updated successfully");
	}
	
	public ParkingHistoryResponse deleteParkingHistory(long id) {
		parkingHistoryRepository.deleteById(id);
		return new ParkingHistoryResponse(null, "Deleted successfully");
	}
}
