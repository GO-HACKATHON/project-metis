package metisv1;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.*;

public class Main {
	
	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	public static void main(String[] args){
		
		final PathService ps = new PathService();
		
		Spark.get("/hello", new Route() {

			public Object handle(Request arg0, Response arg1) throws Exception {
				
				arg1.type("application/json");
				return GSON.toJson("Hello world");
			}
		});
		
		Spark.get("/path", new Route() {

			public Object handle(Request arg0, Response arg1) throws Exception {
				QueryParamsMap query = arg0.queryMap();
				QueryParamsMap start = query.get("start");
				String latlon = start.value();

				QueryParamsMap end = query.get("end");
				String latlon2 = end.value();
				
				QueryParamsMap odd = query.get("odd");
				boolean isOdd = Boolean.parseBoolean(odd.value());
				QueryParamsMap car = query.get("car");
				boolean isCar = Boolean.parseBoolean(car.value());
				GoogleDirectionService gds = new GoogleDirectionService(latlon, latlon2, isCar, isOdd);
				return GSON.toJson(gds.request());
			}
			
		});
		
		Spark.exception(Exception.class, (exception, request, response) -> {
		    exception.printStackTrace();
		});
		
	}

}
