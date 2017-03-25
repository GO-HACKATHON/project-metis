package metisv1;
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
				
				arg1.type("application/json");
				return GSON.toJson("{\nstatus: \"ok\", \ndata: " + ps.dijkstra() + "\n}");
			}
			
		});
	}

}
