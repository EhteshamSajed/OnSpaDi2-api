package com.personal.OnSpaDi2.parkingHisory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ParkingHistoryRepository extends CrudRepository<ParkingHistory, Long>{
	public List<ParkingHistory> findByParkingInformation_ParkingId(Integer id);
	//public List<ParkingHistory> findByParkingId(Integer id);
	//public List<ParkingHistory> findByParkingInformation_Ids(Integer id);
	
	//public List<ParkingHistory> findByParkingInformationParkingId(Integer parkingId);
}
