package com.personal.OnSpaDi2.parkingInformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public ParkingInformation getParkingInformationById(int id) {
		return parkingInformationRepository.findById(id).get();
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
}
