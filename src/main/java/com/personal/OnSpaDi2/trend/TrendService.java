package com.personal.OnSpaDi2.trend;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrendService {

	@Autowired
	private TrendRepository trendRepository;
	
	/* todo
	 * 
	 * implment paging
	 * data between two dates
	 * 
	 * 
	 */
	
	public List<Trend> getAllTrends(String fields){

		List<Trend> trends = new ArrayList<Trend>();
		if(fields != null) {
			String[] fieldsArray = fields.split(",");
			
			Calendar end, start = Calendar.getInstance();
			end = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			try {
				start.setTime(sdf.parse(fieldsArray[0]));
				end.setTime(sdf.parse(fieldsArray[1]));
				System.out.println("------------------------------------------------");
				System.out.println(start.get(Calendar.DATE));
				System.out.println(end.get(Calendar.DATE));
				System.out.println("------------------------------------------------");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			trendRepository.findByDateTimeBetween(start, end).forEach(trends::add);
		}else {
			trendRepository.findAll().forEach(trends::add);
		}
		return trends;
	}
	
	public TrendResponse addTrend(Trend trend) {
		trend = trendRepository.save(trend);		
		return new TrendResponse("New trend inserted", trend.getId());
	}
	
	public Map<String, Object> convertParkingInformationToMap(Trend trend, String fields){
		
		Map<String, Object> trendMap = new HashMap<String, Object>();

		if (fields != null) {
			String[] fieldsArray = fields.split(",");			

			for (int i = 0; i < fieldsArray.length; i++) {
				switch (fieldsArray[i]) {
				case "id":
					trendMap.put(fieldsArray[i], trend.getId());
					break;
				case "dateTime":
					trendMap.put(fieldsArray[i], trend.getDateTime());
					break;
				case "free":
					trendMap.put(fieldsArray[i], trend.getFree());
					break;
				case "occupied":
					trendMap.put(fieldsArray[i], trend.getOccupied());
					break;
				case "total":
					trendMap.put(fieldsArray[i], trend.getTotal());
					break;
				case "locationId":
					trendMap.put(fieldsArray[i], trend.getLocationId());
					break;
				default:
				}
			}
		}else {
			trendMap.put("id", trend.getId());
			trendMap.put("dateTime", trend.getDateTime());
			trendMap.put("free", trend.getFree());
			trendMap.put("occupied", trend.getOccupied());
			trendMap.put("total", trend.getTotal());
			trendMap.put("locationId", trend.getLocationId());
			}
		return trendMap;
		}
	
}