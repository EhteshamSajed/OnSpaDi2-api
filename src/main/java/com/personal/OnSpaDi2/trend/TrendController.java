package com.personal.OnSpaDi2.trend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.OnSpaDi2.locationInformation.LocationInformation;

@RestController
public class TrendController {
	
	@Autowired
	private TrendService trendService;
	
	@RequestMapping("/trend")			//		localhost:8080/trend?fields=2019-04-10 08:57:48,2019-04-14 08:57:48
	public List<Trend> getAllTrends(@RequestParam(required = false) String fields){
		return trendService.getAllTrends(fields);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "locationInformation/{locationId}/trend")
	public TrendResponse addTrend(@RequestBody Trend trend, @PathVariable int locationId) {
		trend.setLocationInformation(new LocationInformation(locationId));
		return trendService.addTrend(trend);
	}	
}