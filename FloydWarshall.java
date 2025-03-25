
public class FloydWarshall {
    final static int INF = 99999; // Representing infinity

    // Function to execute Floyd-Warshall Algorithm
    public static void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        // Initialize the distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist, V);
    }

    // Function to print the distance matrix
    public static void printSolution(int dist[][], int V) {
        System.out.println("All-pairs shortest path matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int graph[][] = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        // Run Floyd-Warshall Algorithm
        floydWarshall(graph, V);
    }
}
