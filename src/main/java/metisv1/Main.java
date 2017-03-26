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
				String latlon = start.values()[0];

				
				QueryParamsMap end = query.get("end");
				String latlon2 = end.values()[0];
				
				GoogleDirectionService gds = new GoogleDirectionService(latlon, latlon2);
				return GSON.toJson(gds.request());
			}
			
		});
	}

}
