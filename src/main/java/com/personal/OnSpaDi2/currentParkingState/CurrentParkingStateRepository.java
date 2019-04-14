package com.personal.OnSpaDi2.currentParkingState;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CurrentParkingStateRepository extends CrudRepository<CurrentParkingState, Long>{
	public CurrentParkingState findByParkingInformation_ParkingId(Integer id);
	public List<CurrentParkingState> findByLocationInformation_LocationId(Integer locationId);
	public int countByLocationInformation_LocationId(int locationId);
	public int countByParkingStateAndLocationInformation_LocationId(String parkingState, int locationId);
	
	/*@Query("SELECT DISTINCT location_id FROM current_parking_state")
	public int[] findDistinctLocationId();*/
	
	//public List<CurrentParkingState> findDistinctLocationIdByParkingState
	
	//public CurrentParkingState findByParkingId(int id);
}
