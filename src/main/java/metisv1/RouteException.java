package metisv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteException {
	private boolean status;
	private int[][] timeApplied;
	private int weekApplied;
	
	public RouteException() {
		
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int[][] getTimeApplied() {
		return timeApplied;
	}

	public void setTimeApplied(int[][] timeApplied) {
		this.timeApplied = timeApplied;
	}

	public int getWeekApplied() {
		return weekApplied;
	}

	public void setWeekApplied(int weekApplied) {
		this.weekApplied = weekApplied;
	}

	
	
	
}
