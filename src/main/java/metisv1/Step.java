package metisv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {
	private Distance distance;
	private Duration duration;
	private Location end_location;
	private Location start_location;
	private String html_instructions;
	private Polyline polyline;
	private String maneuver;
	
	public String getManeuver() {
		return maneuver;
	}

	public void setManeuver(String maneuver) {
		this.maneuver = maneuver;
	}

	public Polyline getPolyline() {
		return polyline;
	}

	public void setPolyline(Polyline polyline) {
		this.polyline = polyline;
	}

	public Step() {
		// TODO Auto-generated constructor stub
	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Location getEnd_location() {
		return end_location;
	}

	public void setEnd_location(Location end_location) {
		this.end_location = end_location;
	}

	public Location getStart_location() {
		return start_location;
	}

	public void setStart_location(Location start_location) {
		this.start_location = start_location;
	}

	public String getHtml_instructions() {
		return html_instructions;
	}

	public void setHtml_instructions(String html_instructions) {
		this.html_instructions = html_instructions;
	}

}
