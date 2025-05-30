package praktikum.graph_disjoint;

public class L0124062_MuhammadDaffaRahman_Graph_AdjacencyMatrix {
    public static void main(String[] args) {
        AdjencyMatrixWeightedDirectedGraph someGraph = new AdjencyMatrixWeightedDirectedGraph(8);
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
        someGraph.printMatrix();
    }
}

class AdjencyMatrixWeightedDirectedGraph {
    private int[][] matrix;
    private int maxVertices;

    public AdjencyMatrixWeightedDirectedGraph(int maxVertices) {
        this.maxVertices = maxVertices;
        this.matrix = new int[maxVertices][maxVertices];
    }

    public void addEdge(int from, int to, int weight) {
        if (from >= 0 && from < maxVertices && to >= 0 && to < maxVertices) {
            matrix[from][to] = weight;
        }
    }

    public int getEdge(int from, int to) {
        if (from >= 0 && from < maxVertices && to >= 0 && to < maxVertices) {
            return matrix[from][to];
        }
        return 0;
    }

    public void printMatrix() {
        System.out.print(" |");
        for (int i = 0; i < maxVertices; i++) {
            System.out.print(String.format("%3c|", 65 + i));
        }
        System.out.print("\n");

        for (int i = 0; i < maxVertices; i++) {
            System.out.print(String.format("%c|", 65 + i));
            for (int j = 0; j < maxVertices; j++) {
                System.out
                        .print(String
                                .format("%3d|", matrix[i][j]));
            }
            System.out.print("\n");
        }
    }
}