package metisv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Direction {
	String status;
	GoogleRoute[] routes;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public Direction() {
		// TODO Auto-generated constructor stub
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GoogleRoute[] getRoutes() {
		return routes;
	}

	public void setRoutes(GoogleRoute[] routes) {
		this.routes = routes;
	}
	
	

}
