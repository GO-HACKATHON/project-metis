package metisv1;

import java.util.ArrayList;
import java.util.List;

public class PathService {
	private String hehe;
	private Graph graph;
	private Direction direction;
	
	public PathService() {
		// TODO Auto-generated constructor stub
		this.graph = new Graph();
	}
	
	public PathService(Direction dir) {
		this.direction = dir;
		this.graph = new Graph();
	}
	
	public String getPath() {
		this.hehe = "hhe";
		return hehe;
	}

	public void setupGraph() {
		List<Location> loc = new ArrayList<Location>();
		List<Edge> edges = new ArrayList<Edge>();
		Edge e = null;
		int currentHead = 0;
		for(GoogleRoute route : direction.getRoutes()){
			for(Leg leg : route.getLegs()){
				for(Step step : leg.getSteps()){
					String toDecode = step.getPolyline().getPoints();
					loc.addAll(PolylineUtil.decode(toDecode));
				}
			}
			for(int i = currentHead; i < loc.size(); i++){
				e = new Edge(loc.get(i), loc.get(i+1), route.getLegs()[0].getDistance(), route.getLegs()[0].getDuration());
			}
		}
	}
	

}
