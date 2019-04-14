package com.personal.OnSpaDi2.scheduler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.personal.OnSpaDi2.currentParkingState.CurrentParkingStateService;
import com.personal.OnSpaDi2.locationInformation.LocationInformation;
import com.personal.OnSpaDi2.trend.Trend;
import com.personal.OnSpaDi2.trend.TrendResponse;
import com.personal.OnSpaDi2.trend.TrendService;

@Component
public class Scheduler {
	
	@Autowired
	private CurrentParkingStateService currentParkingStateService;
	
	@Autowired
	private TrendService trendService;	 
	
	/*@Scheduled(fixedRate = 10000, initialDelay = 2000)
	public void scheduledUpdateTrend() {	
		List<Map<String, Object>> countMaps = currentParkingStateService.countParkingByLocation(null);
		
		for(Map<String, Object> countMap:countMaps) {
			Trend trend = new Trend();
			trend.setFree((int) countMap.get("free"));
			trend.setTotal((int) countMap.get("total"));
			trend.setOccupied((int) countMap.get("occupied"));
			trend.setLocationInformation(new LocationInformation((int) countMap.get("locationId")));
			
			TrendResponse response = trendService.addTrend(trend);
			
			System.out.println(response.getId() + ", " + response.getMessage());
		}		
	}*/
	
}
