package com.personal.OnSpaDi2.trend;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrendRepository extends CrudRepository<Trend, Long> {	
	public List<Trend> findByDateTimeBetween(Calendar start, Calendar stop);
}
