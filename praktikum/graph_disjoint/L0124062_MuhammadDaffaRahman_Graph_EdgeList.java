package praktikum.graph_disjoint;

public class L0124062_MuhammadDaffaRahman_Graph_EdgeList {
    public static void main(String[] args) {
        EdgeListWeightedDirectedGraph someGraph = new EdgeListWeightedDirectedGraph(100);
        someGraph.addEdge(0, 1, 9); // A -> B (9)
        someGraph.addEdge(0, 2, 6); // A -> C (6)
        someGraph.addEdge(0, 7, 10); // A -> H (10)
        someGraph.addEdge(2, 1, 6); // C -> B (6)
        someGraph.addEdge(2, 3, 11); // C -> D (11)
        someGraph.addEdge(2, 4, 7); // C -> E (7)
        someGraph.addEdge(4, 1, 10); // E -> B (10)
        someGraph.addEdge(4, 3, 20); // E -> D (20)
        someGraph.addEdge(4, 5, 12); // E -> F (12)
        someGraph.addEdge(4, 6, 8); // E -> G (8)
        someGraph.addEdge(6, 5, 7); // G -> F (7)
        someGraph.addEdge(7, 3, 13); // H -> D (13)
        someGraph.printEdges();
    }
}

class EdgeListWeightedDirectedGraph {
    private Edge[] edges;
    private int maxEdges;
    private int edgeCount;

    public EdgeListWeightedDirectedGraph(int maxEdges) {
        this.edges = new Edge[maxEdges];
        this.maxEdges = maxEdges;
        this.edgeCount = 0;
    }

    public void addEdge(int from, int to, int weight) {
        if (edgeCount < maxEdges) {
            edges[edgeCount++] = new Edge(from, to, weight);
        } else {
            System.out.println("Edges reached maximum!");
        }
    }

    public void printEdges() {
        for (int i = 0; i < edgeCount; i++) {
            System.out
                    .println(String.format("(%c -> %c, %d)", 'A' + edges[i].from, 'A' + edges[i].to, edges[i].weight));
        }
    }

    private static class Edge {
        public int from;
        public int to;
        public int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}