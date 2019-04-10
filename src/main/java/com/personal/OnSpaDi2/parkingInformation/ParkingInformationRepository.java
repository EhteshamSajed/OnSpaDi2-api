package com.personal.OnSpaDi2.parkingInformation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ParkingInformationRepository extends CrudRepository<ParkingInformation, Integer> {

	public List<ParkingInformation> findByLocationInformation_LocationId(int locationId);
	public int countByLocationInformation_LocationId(int locationId);
}
