package metisv1;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PathEliminationService {
	private boolean isCar;
	private boolean isOdd;
	private Direction direction;
	private FeatureCollection featureCollection;
	private List<Location> loc;
	
	public PathEliminationService(boolean isCar, boolean isOdd, Direction dir) {
		this.isCar = isCar;
		this.isOdd = isOdd;
		this.direction = dir;
		this.loc = new ArrayList<Location>();
		String req = "src/main/resources/exception.json";
		
        ObjectMapper mapper = new ObjectMapper();
        try {
        	this.featureCollection = mapper.readValue(new File(req), FeatureCollection.class);
        } catch (Exception e){
        	e.printStackTrace();
        }
	}
	
	public void calculateOddEven(){
		if(!this.isCar){
			return ;
		}
		for(int i = 0; i < featureCollection.getFeatures().length; i++){
			Feature f = featureCollection.getFeatures()[i];
			Date today = new Date();
			boolean odd = today.getDay() % 2 != 0;
			if(f.getProperties().getOddEven().isStatus() && (isOdd == odd)){
				
			}
		}
	}
	
	
	public Direction calculateAntiBike(){
		if(this.isCar){
			return direction;
		}
		for(int i = 0; i < featureCollection.getFeatures().length; i++){
			Feature f = featureCollection.getFeatures()[i];
			if(f.getProperties().getNoBike() != null && f.getProperties().getNoBike().isStatus()){
				System.out.println("find intersect");
				List<GoogleRoute> routes = findIntersect(f);
				direction.setRoutes(routes.toArray(new GoogleRoute[routes.size()]));
			}
		}
		return direction;
	}

	public List<GoogleRoute> findIntersect(Feature f){

		List<GoogleRoute> newRoutes = Arrays.asList(direction.getRoutes());
		
		
		for(int i = 0; i < direction.getRoutes().length; i++){
			loc.addAll(PolylineUtil.decode(direction.getRoutes()[i].getOverview_polyline().getPoints()));
			for(int ii = 0; ii < loc.size(); ii++){
				Location iii = loc.get(ii);
				double[] j = f.getGeometry().getCoordinates()[0];
				boolean intersect = isIntersect(iii,j);
				if(intersect){
					newRoutes.remove(i);
					break;
				}
				
				double[] k = f.getGeometry().getCoordinates()[1];
				intersect = isIntersect(iii,k);
				if(intersect){
					newRoutes.remove(i);
					break;
				}
				
				
			}
			loc = new ArrayList<Location>();
		}
		
		
		return newRoutes;
		
	}
	
	public boolean isIntersect(Location i, double[] j){
		System.out.println("i" + i.getLat() + " " + i.getLng());
		System.out.println("j" + j[1] + " " + j[0]);
		double dy = i.getLat() - j[1];
		if(dy > 0.005 || dy < -0.005) return false;
		double dx = (i.getLng() - j[0]);
		System.out.println("dydx " + dx*dx + dy*dy);
		return dx*dx + dy*dy < 2.5E-6;
	}
	
	

	public boolean isCar() {
		return isCar;
	}


	public void setCar(boolean isCar) {
		this.isCar = isCar;
	}


	public boolean isOdd() {
		return isOdd;
	}


	public void setOdd(boolean isOdd) {
		this.isOdd = isOdd;
	}


	public FeatureCollection getFeatureCollection() {
		return featureCollection;
	}

	public void setFeatureCollection(FeatureCollection featureCollection) {
		this.featureCollection = featureCollection;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Location> getLoc() {
		return loc;
	}

	public void setLoc(List<Location> loc) {
		this.loc = loc;
	}
	
	
}
