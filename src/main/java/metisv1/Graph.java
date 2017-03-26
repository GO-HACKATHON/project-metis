package metisv1;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<Location> locations;
    private final List<Edge> edges;

    public Graph(){
    	this.locations = new ArrayList<Location>();
    	this.edges = new ArrayList<Edge>();
    }
    
    public Graph(List<Location> locations, List<Edge> edges) {
            this.locations = locations;
            this.edges = edges;
    }

    public List<Location> getLocations() {
            return locations;
    }

    public List<Edge> getEdges() {
            return edges;
    }

}