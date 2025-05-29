package praktikum.graph_disjoint;

import praktikum.AnsiColor;

public class L0124062_MuhammadDaffaRahman_Graph_AdjacencyMatrix {
    public static void main(String[] args) {
        AdjencyMatrixWeightedDirectedGraph someGraph = new AdjencyMatrixWeightedDirectedGraph(8);
        someGraph.set(0, 1, 9); // A -> B (9)
        someGraph.set(0, 2, 6); // A -> C (6)
        someGraph.set(0, 7, 10); // A -> H (10)
        someGraph.set(2, 1, 6); // C -> B (6)
        someGraph.set(2, 3, 11); // C -> D (11)
        someGraph.set(2, 4, 7); // C -> E (7)
        someGraph.set(4, 1, 10); // E -> B (10)
        someGraph.set(4, 3, 20); // E -> D (20)
        someGraph.set(4, 5, 12); // E -> F (12)
        someGraph.set(4, 6, 8); // E -> G (8)
        someGraph.set(6, 5, 7); // G -> F (7)
        someGraph.set(7, 3, 13); // H -> D (13)
        someGraph.printMatrix();
    }
}

class AdjencyMatrixWeightedDirectedGraph {
    private int[][] matrix;
    private int vertices;

    public AdjencyMatrixWeightedDirectedGraph(int vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
    }

    public void set(int from, int to, int weight) {
        if (from >= 0 && from < vertices && to >= 0 && to < vertices) {
            matrix[from][to] = weight;
        }
    }

    public int get(int from, int to) {
        if (from >= 0 && from < vertices && to >= 0 && to < vertices) {
            return matrix[from][to];
        }
        return 0;
    }

    public void printMatrix() {
        System.out.print(AnsiColor.ANSI_WHITE_BACKGROUND + AnsiColor.ANSI_BLACK + " |");
        for (int i = 0; i < vertices; i++) {
            System.out.print(String.format("%3c|", 65 + i));
        }
        System.out.print("\n");

        for (int i = 0; i < vertices; i++) {
            System.out.print(String.format("%s%c|", AnsiColor.ANSI_WHITE_BACKGROUND + AnsiColor.ANSI_BLACK, 65 + i));
            for (int j = 0; j < vertices; j++) {
                System.out
                        .print(String
                                .format("%s%3d%s|",
                                        (matrix[i][j] == 0) ? AnsiColor.ANSI_BLACK_BACKGROUND + AnsiColor.ANSI_WHITE
                                                : AnsiColor.ANSI_GREEN_BACKGROUND + AnsiColor.ANSI_BLACK,
                                        matrix[i][j], AnsiColor.ANSI_BLACK_BACKGROUND + AnsiColor.ANSI_WHITE));
            }
            System.out.print("\n");
        }
    }
}