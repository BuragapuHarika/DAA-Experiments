import java.util.Arrays;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalMST {
    int V, E; // Number of vertices and edges
    Edge[] edges;

    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank)
            subsets[rootX].parent = rootY;
        else if (subsets[rootX].rank > subsets[rootY].rank)
            subsets[rootY].parent = rootX;
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0, i = 0;

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Kruskal's MST:");
        for (i = 0; i < e; i++)
            System.out.println(result[i].src + " - " + result[i].dest + " Weight: " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 6, E = 8;
        KruskalMST graph = new KruskalMST(V, E);

        graph.edges[0] = new Edge();
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 3;

        graph.edges[1] = new Edge();
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 1;

        graph.edges[2] = new Edge();
        graph.edges[2].src = 2;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 2;

        graph.edges[3] = new Edge();
        graph.edges[3].src = 3;
        graph.edges[3].dest = 4;
        graph.edges[3].weight = 1;

        graph.edges[4] = new Edge();
        graph.edges[4].src = 4;
        graph.edges[4].dest = 5;
        graph.edges[4].weight = 2;

        graph.edges[5] = new Edge();
        graph.edges[5].src = 5;
        graph.edges[5].dest = 0;
        graph.edges[5].weight = 4;

        graph.edges[6] = new Edge();
        graph.edges[6].src = 2;
        graph.edges[6].dest = 5;
        graph.edges[6].weight = 6;

        graph.edges[7] = new Edge();
        graph.edges[7].src = 3;
        graph.edges[7].dest = 5;
        graph.edges[7].weight = 5;

        graph.kruskalMST();
    }
}
