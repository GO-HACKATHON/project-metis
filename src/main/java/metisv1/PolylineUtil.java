package metisv1;

import java.util.ArrayList;
import java.util.List;

public class PolylineUtil {
	
	public static List<Location> decode(String point){
		double lat = 0;
		double lng = 0;
		List<Location> locations = new ArrayList<Location>();
		int locLength = point.length();
		int index = 0;
		
		while (index < locLength) {
			int b;
			int shift = 0;
			int result = 0;
			
			do {
                b = point.charAt(index++) - 63;
                result = result | ((b & 0x1f) << shift);
                shift += 5;
            } while (b >= 0x20);
			
			int dlat = (result & 1) != 0 ? ~(result >> 1) : (result >> 1);
            lat += dlat;

            shift = 0;
            result = 0;
            
            do {
                b = point.charAt(index++) - 63;
                result = result | ((b & 0x1f) << shift);
                shift += 5;
            } while (b >= 0x20);

            int dlng = (result & 1) != 0 ? ~(result >> 1) : (result >> 1);
            lng += dlng;
            
            Location p = new Location();
            p.setLat(lat/1e5);
            p.setLng(lng/1e5);
            
            locations.add(p);
		}
		return locations;
	}
}
