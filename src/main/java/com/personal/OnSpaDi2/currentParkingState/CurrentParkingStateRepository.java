package com.personal.OnSpaDi2.currentParkingState;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CurrentParkingStateRepository extends CrudRepository<CurrentParkingState, Long>{
	public CurrentParkingState findByParkingInformation_ParkingId(Integer id);
	//public CurrentParkingState findByParkingId(int id);
}
