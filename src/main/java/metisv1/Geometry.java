package metisv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {
	private double[][] coordinates;
	private String type;
	
	public Geometry() {
		
	}


	public double[][] getCoordinates() {
		return coordinates;
	}



	public void setCoordinates(double[][] coordinates) {
		this.coordinates = coordinates;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
