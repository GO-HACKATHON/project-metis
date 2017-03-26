package metisv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GoogleRoute {
	Leg[] legs;
	Polyline overview_polyline;
	int[] waypoint_order;
	String copyrights;
	String summary;
	String[] warnings;
	
	public String getCopyrights() {
		return copyrights;
	}

	public void setCopyrights(String copyrights) {
		this.copyrights = copyrights;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String[] getWarnings() {
		return warnings;
	}

	public void setWarnings(String[] warnings) {
		this.warnings = warnings;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public GoogleRoute(){
		
	}

	public Leg[] getLegs() {
		return legs;
	}

	public void setLegs(Leg[] legs) {
		this.legs = legs;
	}

	public Polyline getOverview_polyline() {
		return overview_polyline;
	}

	public void setOverview_polyline(Polyline overview_polyline) {
		this.overview_polyline = overview_polyline;
	}

	public int[] getWaypoint_order() {
		return waypoint_order;
	}

	public void setWaypoint_order(int[] waypoint_order) {
		this.waypoint_order = waypoint_order;
	}
	
	
}
