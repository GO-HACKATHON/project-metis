package metisv1;

import java.util.ArrayList;
import java.util.List;

public class PathService {
	private String hehe;
	private List<Vertex> vertex;
	
	public PathService() {
		// TODO Auto-generated constructor stub
		this.vertex = new ArrayList<Vertex>();
	}
	
	public String getPath() {
		this.hehe = "hhe";
		return hehe;
	}

	public List<Vertex> dijkstra(){
		vertex.add(new Vertex("id1", "name1"));
		return vertex;
	}
}
