import java.util.*;

class Graph {
    private int V;
    private List<List<Node>> adj;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
        adj.get(v).add(new Node(u, weight)); // For undirected graph
    }

    void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int[] dist) {
        System.out.println("Shortest path from source vertex:");
        for (int i = 0; i < V; i++)
            System.out.println("Vertex " + i + " Distance: " + dist[i]);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 7);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 7);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 5);
        g.addEdge(4, 5, 8);

        g.dijkstra(0);
    }
}
