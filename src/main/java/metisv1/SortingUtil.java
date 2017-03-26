package metisv1;

import java.util.TreeMap;

public class SortingUtil {
	
	public static Direction pickBestRoute(Direction d){
		int size = d.getRoutes().length;
		TreeMap<Integer, GoogleRoute> map = new TreeMap<Integer, GoogleRoute>();
		for(int i = 0; i < size; i++){
			GoogleRoute r = d.getRoutes()[i];
			map.put(getWeight(r), r);
		}
		GoogleRoute gr = map.get(map.firstKey());
		GoogleRoute[] routes = new GoogleRoute[1];
		routes[0] = gr;
		d.setRoutes(routes);
		return d;
	}
	
	public static int getWeight(GoogleRoute r){
		int weight = 0;
		for(Leg l : r.getLegs()){
			weight = l.getDistance().getValue() + l.getDuration().getValue();
		}
		
		return weight;
	}
}
