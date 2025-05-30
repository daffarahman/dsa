package praktikum.graph_disjoint;

public class L0124062_MuhammadDaffaRahman_Graph_AdjacencyList {
    public static void main(String[] args) {
        AdjacencyListWeightedDirectedGraph someGraph = new AdjacencyListWeightedDirectedGraph(8);
        someGraph.add(0, 1, 9); // A -> B (9)
        someGraph.add(0, 2, 6); // A -> C (6)
        someGraph.add(0, 7, 10); // A -> H (10)
        someGraph.add(2, 1, 6); // C -> B (6)
        someGraph.add(2, 3, 11); // C -> D (11)
        someGraph.add(2, 4, 7); // C -> E (7)
        someGraph.add(4, 1, 10); // E -> B (10)
        someGraph.add(4, 3, 20); // E -> D (20)
        someGraph.add(4, 5, 12); // E -> F (12)
        someGraph.add(4, 6, 8); // E -> G (8)
        someGraph.add(6, 5, 7); // G -> F (7)
        someGraph.add(7, 3, 13); // H -> D (13)
        someGraph.printList();
    }
}

class AdjacencyListWeightedDirectedGraph {
    private Edge[] list;
    private int maxVertices;

    public AdjacencyListWeightedDirectedGraph(int maxVertices) {
        this.list = new Edge[maxVertices];
        this.maxVertices = maxVertices;
    }

    public void add(int from, int to, int weight) {
        if (from >= 0 && from < maxVertices) {
            Edge current = list[from];
            if (current == null) {
                list[from] = new Edge(to, weight);
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Edge(to, weight);
            }
        }
    }

    public int get(int from, int to) {
        Edge current = list[from];
        while (current != null) {
            if (current.to == to)
                return current.weight;
            current = current.next;
        }
        return 0;
    }

    public void printList() {
        for (int i = 0; i < maxVertices; i++) {
            System.out.print(String.format("|%c| -> ", 'A' + i));

            Edge current = list[i];
            while (current != null) {
                System.out.print(String.format("%c(%d) -> ", 'A' + current.to, current.weight));
                current = current.next;
            }

            System.out.print("\n");
        }
    }

    private static class Edge {
        public int to;
        public int weight;
        public Edge next;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}