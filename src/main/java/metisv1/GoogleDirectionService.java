package metisv1;

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
		String[] latlon = start.split(",");
		this.lats = Double.parseDouble(latlon[0]);
		this.lons = Double.parseDouble(latlon[1]);
		String[] latlon2 = end.split(",");
		this.late = Double.parseDouble(latlon2[0]);
		this.lone = Double.parseDouble(latlon2[1]);
		
	}
	
	
	public void request() {
		String req = "https://maps.googleapis.com/maps/api/directions/"
				+ "json?origin="+start+"&destination="+end
				+ "&key="+ API_KEY;
		
		
	}

	public double getLats() {
		return lats;
	}

	public void setLats(double lats) {
		this.lats = lats;
	}

	public double getLons() {
		return lons;
	}

	public void setLons(double lons) {
		this.lons = lons;
	}

	public double getLate() {
		return late;
	}

	public void setLate(double late) {
		this.late = late;
	}

	public double getLone() {
		return lone;
	}

	public void setLone(double lone) {
		this.lone = lone;
	}
	
	

}
