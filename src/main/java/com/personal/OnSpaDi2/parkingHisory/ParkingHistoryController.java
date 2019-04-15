package com.personal.OnSpaDi2.parkingHisory;

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
public class ParkingHistoryController {
	
	@Autowired
	private ParkingHistoryService parkingHistoryService;
	
	@RequestMapping("/parkingHistory")
	public List<ParkingHistory> getAllParkingHistory(){
		return parkingHistoryService.getAllParkingHistory();
	}	
	
	@RequestMapping("/parkingInformation/{id}/parkingHistory")
	public List<ParkingHistory> getAllParkingHistory(@PathVariable int id) {
		return parkingHistoryService.getAllParkingHistory(id);
	}
	
	@RequestMapping("/parkingHistory/{id}")					//	@RequestMapping("parkingInformation/{parkingInformationId}/parkingHistory/{parkingHistoryId}")
	public ParkingHistory getParkingHistoryById(@PathVariable long id) {
		return parkingHistoryService.getParkingHistoryById(id);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/parkingHistory")
	public ParkingHistoryResponse addParkingHistory(@RequestBody ParkingHistory parkingHistory) {		
		return parkingHistoryService.addParkingHistory(parkingHistory);		
	}*/	

	@RequestMapping(method = RequestMethod.POST, value = "parkingInformation/{parkingInformationId}/parkingHistory")
	public ParkingHistoryResponse addParkingHistory(@RequestBody ParkingHistory parkingHistory, @PathVariable int parkingInformationId) {
		parkingHistory.setParkingInformation(new ParkingInformation(parkingInformationId, 0, 0));
		return parkingHistoryService.addParkingHistory(parkingHistory);		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/parkingHistory")
	public ParkingHistoryResponse updateParkingHistory(@RequestBody ParkingHistory parkingHistory) {
		return parkingHistoryService.updateParkingHistory(parkingHistory);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "parkingInformation/{parkingInformationId}/parkingHistory")
	public ParkingHistoryResponse updateParkingHistory(@RequestBody ParkingHistory parkingHistory, @PathVariable int parkingInformationId) {
		parkingHistory.setParkingInformation(new ParkingInformation(parkingInformationId, 0, 0));
		return parkingHistoryService.updateParkingHistory(parkingHistory);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkingHistory/{id}")
	public ParkingHistoryResponse deleteParkingHistory(@PathVariable long id) {
		return parkingHistoryService.deleteParkingHistory(id);
	}
}
