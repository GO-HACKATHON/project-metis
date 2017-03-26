package metisv1;

public class Edge  {
    private Location source;
    private Location destination;
    private Distance distance;
    private Duration duration;

    public Edge(Location source, Location destination, Distance d, Duration du) {
            this.source = source;
            this.destination = destination;
            this.distance = d;
            this.duration = du;
    }

    public Location getDestination() {
            return destination;
    }

    public Location getSource() {
            return source;
    }
    public int getWeight() {
            return this.duration.getValue() + this.distance.getValue();
    }

    @Override
    public String toString() {
            return source + " " + destination;
    }


}
