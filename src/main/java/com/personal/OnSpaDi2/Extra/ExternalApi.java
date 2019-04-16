package com.personal.OnSpaDi2.Extra;

public class ExternalApi {
	public int getTraffic() {
		return (int)(Math.random() * 4);
	}
	
	public int getIsEvent() {
		return (int)(Math.random() * 1);
	}
	
	public int getIsRaining() {
		return (int)(Math.random() * 1);
	}
	
	public int getIsSnowing() {
		return (int)(Math.random() * 1);
	}
}
