package metisv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Property {
	private String name;
	private RouteException oddEven;
	private RouteException carFreeDay;
	private RouteException threeInOne;
	private RouteException noBike;
	
	public Property() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RouteException getOddEven() {
		return oddEven;
	}

	public void setOddEven(RouteException oddEven) {
		this.oddEven = oddEven;
	}

	public RouteException getCarFreeDay() {
		return carFreeDay;
	}

	public void setCarFreeDay(RouteException carFreeDay) {
		this.carFreeDay = carFreeDay;
	}

	public RouteException getThreeInOne() {
		return threeInOne;
	}

	public void setThreeInOne(RouteException threeInOne) {
		this.threeInOne = threeInOne;
	}

	public RouteException getNoBike() {
		return noBike;
	}

	public void setNoBike(RouteException noBike) {
		this.noBike = noBike;
	}
	
	
	
}
