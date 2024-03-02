package ASTC;

public class ShortestPath {

    static final int V = 20;
    static final int EDGE_COUNT = 30;
    static final int DEFAULT_COST = 1000;
    int[][] dist;
    String[] countries;

    private int shortestPathCost;
    String source, destination;

    public ShortestPath(String source, String destination) {
        this.source = source;
        this.destination = destination;

        dist = new int[V][V];
        countries = new String[]{
                "Afghanistan", "Bahrain", "Bangladesh", "Bhutan", "Brunei",
                "Cambodia", "China", "India", "Indonesia", "Iran",
                "Iraq", "Pakistan", "Japan", "Jordan", "Kazakhstan",
                "Kuwait", "Kyrgyzstan", "Laos", "Lebanon", "Malaysia"
        };


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = DEFAULT_COST;
            }
        }


        for (int e = 0; e < EDGE_COUNT; e++) {
            int i = (int) (Math.random() * V);
            int j = (int) (Math.random() * V);
            int cost = (int) (Math.random() * 300) + 1;
            dist[i][j] = cost;
            dist[j][i] = cost;
        }

    }

    public void findShortestPath() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    public int CheckIndex(String country) {
        for (int i = 0; i < V; i++) {
            if (countries[i].equalsIgnoreCase(country)) {
                return i;
            }
        }
        return -1;
    }

    public String  getShortestPathCost() {
        findShortestPath();
        return String.valueOf(shortestPathCost);
    }

}


























