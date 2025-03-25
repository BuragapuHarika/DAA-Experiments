import java.util.Arrays;

class PrimMST {
    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int[][] graph) {
        int V = graph.length;
        boolean[] inMST = new boolean[V]; 
        int[] key = new int[V]; 
        int[] parent = new int[V];

        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, inMST, V);
            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST(parent, graph);
    }

    private static int minKey(int[] key, boolean[] inMST, int V) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Prim's MST:");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "  Weight: " + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, 0, 0, 0, 1},
            {3, 0, 1, 0, 4, 0},
            {0, 1, 0, 6, 0, 2},
            {0, 0, 6, 0, 5, 0},
            {0, 4, 0, 5, 0, 0},
            {1, 0, 2, 0, 0, 0}
        };
        primMST(graph);
    }
}
