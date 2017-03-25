package metisv1;

import java.util.regex.Pattern;

import org.springframework.web.client.RestTemplate;

public class GoogleDirectionService {
	private double lats;
	private double lons;
	private double late;
	private double lone;
	private String start;
	private String end;
	public static final String API_KEY = "AIzaSyDsZhgr1efJIz_i2fyvFKcCbl35veBNYG8";
	
	public GoogleDirectionService() {
		// TODO Auto-generated constructor stub
	}
	
	public GoogleDirectionService(String start, String end){
		this.start = start;
		this.end = end;
		
		if(Pattern.matches("[A-Za-z ]+", start) == false){
			String[] latlon = start.split(",");
			this.lats = Double.parseDouble(latlon[0]);
			this.lons = Double.parseDouble(latlon[1]);
		}
		
		if(Pattern.matches("[A-Za-z ]+", end) == false){
			String[] latlon2 = end.split(",");
			this.late = Double.parseDouble(latlon2[0]);
			this.lone = Double.parseDouble(latlon2[1]);
		}
		
	}
	
	
	public Direction request() {
		String req = "https://maps.googleapis.com/maps/api/directions/"
				+ "json?origin="+start+"&destination="+end
				+ "&alternatives=true&key="+ API_KEY;
		
		RestTemplate restTemplate = new RestTemplate();
        Direction dir = restTemplate.getForObject(req, Direction.class);
        return dir;
	}

}
